CREATE TABLE transactions (
    id UUID PRIMARY KEY,
    transaction_raw VARCHAR(255) NOT NULL,
    card_raw VARCHAR(255),
    merchant_raw VARCHAR(255) NOT NULL,
    amount_raw VARCHAR(255) NOT NULL,
    name_raw VARCHAR(255) NOT NULL,
    raw_payload JSONB NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);
