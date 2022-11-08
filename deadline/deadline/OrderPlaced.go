package deadline

import (
	"time"
)

type OrderPlaced struct{
	EventType string	`json:"eventType" type:"string"`
	TimeStamp string 	`json:"timeStamp" type:"string"`
	Id int `json:"id" type:"int"` 
	CurrencyId string `json:"currencyId" type:"string"` 
	Amount  `json:"amount" type:""` 
	HolderId string `json:"holderId" type:"string"` 
	
}

func NewOrderPlaced() *OrderPlaced{
	event := &OrderPlaced{EventType:"OrderPlaced", TimeStamp:time.Now().String()}

	return event
}
