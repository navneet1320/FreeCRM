Feature: Deal data creation

Scenario: Free CRM Create a new deal scenario

Given user is already on Login Page
When title of login page is Free CRM
Then close the live chatbox
Then user enters username and password
| username | password |
| dharap | dhara123 |

Then user clicks on login button
Then user is on home page
Then user moves to new deal page
Then user enters deal details
| title | amount | probability | commission |
| test deal1 | 2000 | 30 | 10 |
| test deal2 | 1000 | 50 | 20 |
| test deal3 | 3000 | 60 | 80 |