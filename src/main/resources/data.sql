SET SCHEMA ANZ_SCHEMA;
-- TODO create a single user
INSERT INTO ANZUSER (ID) VALUES (1);
INSERT INTO ANZUSER (ID) VALUES (2);
-- TODO create mapping between accounts and users in DDL if needed
INSERT INTO ACCOUNT (ACCOUNT_NUMBER, USER_ID, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, OPENING_AVAILABLE_BALANCE ) VALUES ('a1', '1', 'one account', 'Savings', '2022-04-13', 'SGD', 120.12);
INSERT INTO ACCOUNT (ACCOUNT_NUMBER, USER_ID, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, OPENING_AVAILABLE_BALANCE ) VALUES ('a2', '1', 'two account', 'Current', '2022-04-15', 'AUD', 140.12);

INSERT INTO ACCOUNT (ACCOUNT_NUMBER, USER_ID, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, OPENING_AVAILABLE_BALANCE ) VALUES ('a3', '2', 'one2 account', 'Savings', '2022-04-13', 'SGD', 120.12);
INSERT INTO ACCOUNT (ACCOUNT_NUMBER, USER_ID, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, OPENING_AVAILABLE_BALANCE ) VALUES ('a4', '2', 'two2 account', 'Current', '2022-04-15', 'AUD', 140.12);

INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t1', 'a1', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t2', 'a1', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t3', 'a1', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t4', 'a1', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t5', 'a1', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t6', 'a1', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t7', 'a1', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');


INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t8', 'a2', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t9', 'a2', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t10', 'a2', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t11', 'a2', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t12', 'a2', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t13', 'a2', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t14', 'a2', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');

INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t15', 'a3', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t16', 'a3', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t17', 'a3', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t18', 'a3', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t19', 'a3', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t20', 'a3', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');
INSERT INTO TRANSACTION (TRANSACTION_ID, ACCOUNT_NUMBER, VALUE_DATE, CURRENCY, CREDIT_AMOUNT, TRANSACTION_TYPE, TRANSACTION_NARRATIVE) VALUES('t21', 'a3', '2022-04-13', 'SGD', 20.45, 'Credit','Test comment');