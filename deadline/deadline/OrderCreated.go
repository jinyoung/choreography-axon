package deadline

import (
	"time"
)

type OrderCreated struct{
	EventType string	`json:"eventType" type:"string"`
	TimeStamp string 	`json:"timeStamp" type:"string"`
	Id int `json:"id" type:"int"` 
	CurrencyId string `json:"currencyId" type:"string"` 
	Amount  `json:"amount" type:""` 
	HolderId string `json:"holderId" type:"string"` 
	
}

func NewOrderCreated() *OrderCreated{
	event := &OrderCreated{EventType:"OrderCreated", TimeStamp:time.Now().String()}

	return event
}
