#udremyocwbqhaslcnv@bvhrs.com
#  password

Feature: Authorization - signing in

  Scenario Outline: Adding new addresses
    Given user is on the main page
    When user signs in
    And clicks Addresses
    And creates new address with given <alias>, <address>, <city>, <zipcode>, <country> and <phone>
    Then checks if in <alias> are correct <address>, <city>, <zipcode>, <country> and <phone>
    Examples:
      | alias    | address | city  | zipcode  | country          | phone       |
      | "first"  | "some"  | "lor" | "87-123" | "United Kingdom" | "123456789" |
      | "second" | "any"   | "em"  | "05-050" | "United Kingdom" | "987654321" |