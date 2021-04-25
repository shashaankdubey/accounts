# accounts

This is a spring boot project having 5 rest APIs for CRUD operations.
H2 is used as in memory database.
It follows the basic project structure, controller folder for controller layer, service folder for service layer, repository folder for database operations.

Test Approach :
There is an integration test class which tests few of the rest APIs running the application end to end as spring boot application.

CI workflow:
CI workflow has been created using Git Actions which contains compile, test and build phases.

Some important URLs to test the application once started on 8080 port :
Get all accounts : http://localhost:8080/accounts
Get account by ID : http://localhost:8080/accounts/{id}
Create new Account : http://localhost:8080/accounts/create
Update account : http://localhost:8080/accounts/update
Delete account : http://localhost:8080/accounts/delete/{id}

Request Body example : 
{
	"id":"1",
	"phone":"2222222222",
    "name":"Generic Name",
	"email":"genericname@company.com",
	"address":"GenericStreet 42 Earth",
	"country":"Navarro",
	"department":"T21R"
}
