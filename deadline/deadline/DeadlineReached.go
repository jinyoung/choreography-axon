package deadline

import (
	"time"
)

type DeadlineReached struct{
	EventType string	`json:"eventType" type:"string"`
	TimeStamp string 	`json:"timeStamp" type:"string"`
	Id int `json:"id" type:"int"` 
	Deadline  `json:"deadline" type:""` 
	OrderId int `json:"orderId" type:"int"` 
	StartedTime  `json:"startedTime" type:""` 
	
}

func NewDeadlineReached() *DeadlineReached{
	event := &DeadlineReached{EventType:"DeadlineReached", TimeStamp:time.Now().String()}

	return event
}
