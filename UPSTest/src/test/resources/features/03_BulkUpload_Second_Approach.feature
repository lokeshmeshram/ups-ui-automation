@QA-REGRESSION @QA-FEATURE-EQUIPMENT-BULK-UPLOAD
Feature: Automation Scenarios for Bulk Upload feature test for Equipment page.

  Background: Set login user
    Given Set default logged in user

  @Update_D&D_details
  Scenario Outline: [UPS-11] : Verify User should be able to perform bulk upload operation for "Update D&amp;D details" functionality.
    Given User should navigate to "Equipment" page
    Then User Verify "Update D&D details" button is enabled
    Given User Select multiple record with rowNumbers=<rowNumbers>
    And User Click "Update D&D details" button
    Then Verify "Update D&D details" page Should get displayed
    Then Verify "Save" button is enabled
    Given User click dropdown "Demurrage"
    And Select dropdown "<dropDownName1>" with Values "<dropDownValue1>"
    And Select dropdown "<dropDownName2>" with Values "<dropDownValue2>"
    And User Click "Save" button
    Then Verify "<notification>" message
    Given User should navigate to "Equipment" page
    Then User Verify "Update D&D details" button is enabled
    Given User Select multiple record with rowNumbers=<rowNumbers>
    And Verify Select dropdown "<dropDownName1>" having Values "<dropDownValue1>"
    And Verify Select dropdown "<dropDownName2>" having Values "<dropDownValue2>"
    And User Click "Cancel" button
    Then Verify "Equipment" page Should get displayed

    Examples:
      | rowNumbers  | dropDownName1 | dropDownValue1                                               | dropDownName2 | dropDownValue2                           | notification                                                 |
      | 1,2,5       | Demurrage     | Data/documentation is incorrect, delayed or lost – Forwarder | Detention     | Consignee lack of capacity for unloading | Bulk Update is Success for functionality :Update D&D details |
      | 3,4         | Demurrage     | Exceptional natural or industrial disaster                   | Detention     | Consignee lack of capacity for unloading | Bulk Update is Success for functionality :Update D&D details |
      | 6,7         | Demurrage     | Import customs clearance delay                               | Detention     | Consignee lack of capacity for unloading | Bulk Update is Success for functionality :Update D&D details |
      | 8,9,10      | Demurrage     | Incorrect/no forecasting                                     | Detention     | Consignee lack of capacity for unloading | Bulk Update is Success for functionality :Update D&D details |
      | 11,12,45    | Demurrage     | Incorrect booking/pre-advice                                 | Detention     | Consignee lack of capacity for unloading | Bulk Update is Success for functionality :Update D&D details |
      | 43,41,5     | Demurrage     | Incorrect or missing labeling - Shipper                      | Detention     | Consignee lack of capacity for unloading | Bulk Update is Success for functionality :Update D&D details |

      | 20,21,24,26 | Demurrage     | Exceptional natural or industrial disaster                   | Detention     | Import customs clearance delay           | Bulk Update is Success for functionality :Update D&D details |
      | 31,33,35,36 | Demurrage     | Exceptional natural or industrial disaster                   | Detention     | Incorrect booking/pre-advice             | Bulk Update is Success for functionality :Update D&D details |
      | 40,41,24,26 | Demurrage     | Exceptional natural or industrial disaster                   | Detention     | Incorrect/no forecasting                 | Bulk Update is Success for functionality :Update D&D details |
      | 40,41,24,26 | Demurrage     | Exceptional natural or industrial disaster                   | Detention     | National Holiday                         | Bulk Update is Success for functionality :Update D&D details |