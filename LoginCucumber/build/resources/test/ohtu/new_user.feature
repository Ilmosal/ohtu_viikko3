Feature: A new user account can be created if a proper unused username and password are given
    
    Scenario: user can not login with incorrect password
        Given command login is selected
        When username "pekka" and password "vaara123a" are entered
        Then system will respond with "wrong username or password"

      
    Scenario: nonexistent user can not login to
        Given command login is selected
        When username "what" and password "akkep123a" are entered
        Then system will respond with "wrong username or password"