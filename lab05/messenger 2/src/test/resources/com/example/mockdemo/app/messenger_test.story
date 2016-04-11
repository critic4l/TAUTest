Given a messenger

When server connection succeed
Then sending valid message should return 0

When server connection succeed
Then sending invalid message should return 1

When server connection failed
Then sending valid message should return 1

When server connection failed
Then sending invalid message should return 1