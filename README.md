# Assignment

* This is the sample project demonstrating the use cases for the technologies Spring Boot, Eureka, Resilience4J etc.

* This sample project contains following components :
    * discovery-server
        * runs on port `8761`
    * fund-transfer
        * runs on port `8081`
    * forex-service
        * runs on port `8082`
        * `fund-transfer` service communicates using the REST
    * credit-service
        * runs on port `8083`
        * `fund-transfer` service communicates using Apache Kafka. `apache-credit` topic is used for communication
    * debit-service
        * runs on port `8084`
        * `fund-transfer` service communicates using Apache Kafka. `apache-debit` topic is used for communication
    * api-gateway
        * runs on port `8085`
        * `api-gateway` is used for communication with external consumers.

### Apis

| API | Request | Response |
|:---:|:-------:|:--------:|
| /api/funds/transfer | { "srcAccount" : "101", "destAccount" : "102", "amount" : 1}| { "creditedAmount" : \<double\>, "debitedAmount" : \<double\>, "message" : ""}|