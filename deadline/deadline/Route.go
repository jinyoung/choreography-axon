package deadline

import (
	"github.com/labstack/echo"
	"net/http"
)

func RouteInit() *echo.Echo {
	e := echo.New()
	e.GET("/healthcheck", func(c echo.Context) error {
		return c.JSON(http.StatusOK, "ok")
	})
	deadline := &Deadline{}
	e.GET("/deadlines", deadline.Get)
	e.GET("/deadlines/:id", deadline.FindById)
	e.POST("/deadlines", deadline.Persist)
	e.PUT("/deadlines/:id", deadline.Put)
	e.DELETE("/deadlines/:id", deadline.Remove)
	return e
}
