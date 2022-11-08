package deadline

import (
	"gopkg.in/jeevatkm/go-model.v1"
	
	"gorm.io/gorm"
	"fmt"
	"deadline/external"
)

type Deadline struct {
	gorm.Model
	Id int `gorm:"primaryKey" json:"id" type:"int"`
	Deadline undefined `json:"deadline"`
	OrderId int `json:"orderId"`
	StartedTime undefined `json:"startedTime"`

}

func (self *Deadline) onPostPersist() (err error){
	deadlineReached := NewDeadlineReached()
	model.Copy(deadlineReached, self)

	Publish(deadlineReached)

	return nil
}
func (self *Deadline) onPrePersist() (err error){ return nil }
func (self *Deadline) onPreUpdate() (err error){ return nil }
func (self *Deadline) onPostUpdate() (err error){ return nil }
func (self *Deadline) onPreRemove() (err error){ return nil }
func (self *Deadline) onPostRemove() (err error){ return nil }


func (self *Schedule) Schedule(orderCreated *OrderCreated){
	/** Example 1:  new item
	deadline := &Deadline{}
	deadlinerepository.save(deadline)

	*/

	/** Example 2:  finding and process
	id, _ := strconv.ParseInt(orderCreated.id, 10, 64)
	point, err := PointRepository().FindById(int(id))
	if err != nil {

	}
	*/
}
func (self *RemoveDeadline) RemoveDeadline(orderPlaced *OrderPlaced){
	/** Example 1:  new item
	deadline := &Deadline{}
	deadlinerepository.save(deadline)

	*/

	/** Example 2:  finding and process
	id, _ := strconv.ParseInt(orderPlaced.id, 10, 64)
	point, err := PointRepository().FindById(int(id))
	if err != nil {

	}
	*/
}
