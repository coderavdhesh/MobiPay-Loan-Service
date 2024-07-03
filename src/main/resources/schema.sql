CREATE TABLE IF NOT EXISTS loan_data (
    loan_account_number VARCHAR(255) NOT NULL PRIMARY KEY,
    due_date DATE,
    emi_amount DOUBLE
);