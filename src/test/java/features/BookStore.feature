@BookStore
Feature: BookStore
  Scenario: Generate random user
    * Create a randomized user
    * Generate token for the user in context
    * Delete the user in context

  @BookStoreAuthentication @SCN-Post-Book-Test
  Scenario: Post book
    * Get all books from database
    * Post books by publisher named O'Reilly Media to the user in context
    * Get user in context
    * Verify book information for the user in context
    * Delete the user in context

  Scenario: Create user
    * Create user with following:
      | Username | Pickleboy1      |
      | Password | s3curePassw0rd! |

  Scenario: Generate token
    * Generate token for following user:
      | Username | Pickleboy1      |
      | Password | s3curePassw0rd! |
