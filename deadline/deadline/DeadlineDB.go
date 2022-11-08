package deadline
import (
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
	"log"
)

type DeadlineDB struct{
	db *gorm.DB
}

var deadlinerepository *DeadlineDB

func DeadlineDBInit() {
	var err error
	deadlinerepository = &DeadlineDB{}
	deadlinerepository.db, err = gorm.Open(sqlite.Open("Deadline_table.db"), &gorm.Config{})
	
	if err != nil {
		panic("DB Connection Error")
	}
	deadlinerepository.db.AutoMigrate(&Deadline{})

}

func DeadlineRepository() *DeadlineDB {
	return deadlinerepository
}

func (self *DeadlineDB)save(entity interface{}) error {
	
	tx := self.db.Create(entity)

	if tx.Error != nil {
		log.Print(tx.Error)
		return tx.Error
	}
	return nil
}

func (self *DeadlineDB)GetList() []Deadline{
	
	entities := []Deadline{}
	self.db.Find(&entities)

	return entities
}

func (self *DeadlineDB)FindById(id int) (*Deadline, error){
	entity := &Deadline{}
	txDb := self.db.Where("id = ?", id)
	if txDb.Error != nil {
		return nil, txDb.Error
	} else {
		txDbRow := txDb.First(entity)
		if txDbRow.Error != nil {
			return nil, txDbRow.Error
		}
		return entity, nil
	}
}

func (self *DeadlineDB) Delete(entity *Deadline) error{
	err2 := self.db.Delete(&entity).Error
	return err2
}

func (self *DeadlineDB) Update(id int, params map[string]string) error{
	entity := &Deadline{}
	txDb := self.db.Where("id = ?", id)
	if txDb.Error != nil {
		return nil, txDb.Error
	} else {
		txDbRow := txDb.First(entity)
		if txDbRow.Error != nil {
			return nil, txDbRow.Error
		}
		update := &Deadline{}
		err := ObjectMapping(update, params)
		if err != nil {
			return nil, err
		}
		self.db.Model(&entity).Updates(update)

		return entity, nil
	}
}