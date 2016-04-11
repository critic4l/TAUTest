Given a messenger

When connecting with VALID_SERVER
Then connection status should return 0

When connecting with INVALID_SERVER
Then connection status should return 1

When sending valid message
Then message status on VALID_SERVER should return 1 or 0

When sending valid message
Then message status on INVALID_SERVER should return 1

When sending invalid message
Then message status on INVALID_SERVER should return 2