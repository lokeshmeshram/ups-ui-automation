@QA-REGRESSION @QA-FEATURE-EQUIPMENT-BULK-UPLOAD
Feature: Automation Scenarios for Bulk Upload feature test for Equipment page.

  Background: Set login user
    Given Set default logged in user

  @Update_D&D_details @positive
  Scenario: [UPS-01] : Verify User should be able to perform bulk upload operation for "Update D&amp;D details" functionality Using Excel.
    Given User should navigate to "Equipment" page
    Then User Verify "Update D&D details" button is enabled
    Given User Select multiple record with equipmentNumber="eq-001,eq-002,eq-003,eq-004,eq-005,eq-006,eq-007,eq-008,eq-009,eq-010" for Action="Update D&D details"

  @Update_D&D_details @positive
  Scenario: [UPS-01] : Verify all available webelement/fields available on "Update D&amp;D details" page
    Given User should navigate to "Equipment" page
    Then User Verify "Update D&D details" button is enabled
    Given User Select multiple record with rowNumbers=1
    And User Click "Update D&D details" button
    Then Verify "Update D&D details" page Should get displayed
    Then Verify "Gate out port" field for section "Demurrage" should get displayed
    Then Verify "Number of days demurrage" field for section "Demurrage" should get displayed
    Then Verify "Reason Code" field for section "Demurrage" should get displayed
    Then Verify "Responsible" field for section "Demurrage"  should get displayed

    Then Verify "Update D&D details" page Should get displayed
    Then Verify "Gate out port" field for section "Detention" should get displayed
    Then Verify "Number of days demurrage" field for section "Detention" should get displayed
    Then Verify "Reason Code" field for section "Detention" should get displayed
    Then Verify "Responsible" field for section "Detention"  should get displayed

    Then Verify "Comment" field should get displayed
    Then Verify "Cancel" field should get displayed
    Then Verify "Save" field should get displayed

  @Update_D&D_details @negative
  Scenario: [UPS-04] : Verify User should not be able to perform bulk upload operation for dropdown Demurrage/Detention = blank/unselected
  Scenario : [UPS-11] : Verify User should be able to perform bulk upload operation for "Update D&amp;D details" functionality.
    Given User should navigate to "Equipment" page
    Then User Verify "Update D&D details" button is enabled
    Given User Select multiple record with rowNumbers=2,4,6
    And User Click "Update D&D details" button
    Then Verify "Update D&D details" page Should get displayed
    Then Verify "Save" button is enabled
    And User Click "Save" button
    Then Verify "No record is updated for black values for dropdown Demurrage/Detention" message

  @Update_transport_details @positive
  Scenario: [UPS-02] : Verify User should be able to perform bulk upload operation for "Update transport details" functionality Using Excel.
    Given User should navigate to "Equipment" page
    Then User Verify "Update transport details" button is enabled
    Given User Select multiple record with equipmentNumber="eq-011,eq-012,eq-013,eq-014" for Action="Update transport details"

  @update_final_delivery_details @positive
  Scenario: [UPS-03] : Verify User should be able to perform bulk upload operation for "update final delivery details" functionality Using Excel.
    Given User should navigate to "Equipment" page
    Then User Verify "update final delivery details" button is enabled
    Given User Select multiple record with equipmentNumber="eq-021,eq-022,eq-023,eq-024" for Action="update final delivery details"





