@QA-REGRESSION @QA-FEATURE-EQUIPMENT-BULK-UPLOAD
Feature: Automation Scenarios for Bulk Upload feature test for Equipment page.

  Background: Set login user
    Given Set default logged in user

  @Update_D&D_details
  Scenario: [UPS-01] : Verify User should be able to perform bulk upload operation for "Update D&amp;D details" functionality Using Excel.
    Given User should navigate to "Equipment" page
    Then User Verify "Update D&D details" button is enabled
    Given User Select multiple record with equipmentNumber="eq-001,eq-002,eq-003,eq-004,eq-005,eq-006,eq-007,eq-008,eq-009,eq-010" for Action="Update D&D details"

  @Update_transport_details
  Scenario: [UPS-02] : Verify User should be able to perform bulk upload operation for "Update transport details" functionality Using Excel.
    Given User should navigate to "Equipment" page
    Then User Verify "Update transport details" button is enabled
    Given User Select multiple record with equipmentNumber="eq-011,eq-012,eq-013,eq-014" for Action="Update transport details"

  @update_final_delivery_details
  Scenario: [UPS-03] : Verify User should be able to perform bulk upload operation for "update final delivery details" functionality Using Excel.
    Given User should navigate to "Equipment" page
    Then User Verify "update final delivery details" button is enabled
    Given User Select multiple record with equipmentNumber="eq-021,eq-022,eq-023,eq-024" for Action="update final delivery details"


  @Update_D&D_details
  Scenario Outline: [UPS-01] : Verify User should be able to perform bulk upload operation for "Update D&amp;D details" functionality.
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


#	Questions:
#	  1. What is mandatory fields for Updating/inserting "Update D&D details" ?
#	  2. What are fields non editable on Update D&D details" page ?
#	  2. Need validation details for each editable fields during Updating/inserting "Update D&D details"
#	  3. Can we specify any combinations values for dropdown "Demurrage" & "Detention" ?
#	  4. Is it possible to save "Update D&D details" by selecting value for only "Demurrage" dropdown and keep other dropdown "Detention" black/unselected or vice-versa ?
#	  5. Is it possible to keep both dropdown values as black/unselected & save "Update D&D details"
#	  6. What is Max row User can select for Multi Upload functionality ?
#	  7. How Pagination is Handle ? what is page Size ?
