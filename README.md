# spring-boot-example


Connect to actuator using 
```shell
ssh -p 2000 user@localhost
```

Test a custom crash command : 

```shell
help
ExampleCommand -h
ExampleCommand current-thread
ExampleCommand version -c ALL
````

Helper endpoints to test the dashboard command :

http://localhost:8080/dashboard/deadlock
http://localhost:8080/dashboard/sleep
