package deadline

import (
	"github.com/mitchellh/mapstructure"
)

func wheneverOrderCreated_Schedule(data map[string]interface{}){
	
	event := NewOrderCreated()
	mapstructure.Decode(data,&event)
	deadline := &Deadline{}
	// TODO Set value from event ( ex: delivery.OrderId = event.Id )
	// TODO Change according to the event (save, delete, put..)
	deadlinerepository.save(deadline)

	// Sample Logic //
	deadline.Schedule(event);
}

func wheneverOrderPlaced_RemoveDeadline(data map[string]interface{}){
	
	event := NewOrderPlaced()
	mapstructure.Decode(data,&event)
	deadline := &Deadline{}
	// TODO Set value from event ( ex: delivery.OrderId = event.Id )
	// TODO Change according to the event (save, delete, put..)
	deadlinerepository.save(deadline)

	// Sample Logic //
	deadline.RemoveDeadline(event);
}

