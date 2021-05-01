Feature: Application login123

Scenario Outline: Homepage login
Given driver initialize  
And User is on landing page using link "http://qaclickacademy.com"
When click on login link
Then enter "test99@gmail.com" and "123456" and click on submit
And close browser

Examples:
|username             |password|
|test99@gmail.com     |123456  |
|lltsonawane@gmail.com|3423423 |
