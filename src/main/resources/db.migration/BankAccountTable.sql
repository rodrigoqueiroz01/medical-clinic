CREATE TABLE public.bank_account (
    id                  UUID         NOT NULL,
    titular_name        VARCHAR(255) NOT NULL,
    payday_one          INTEGER      NOT NULL,
    payday_two          INTEGER      NOT NULL,
    banking_institution VARCHAR(100) NOT NULL,
    agency_number       VARCHAR(4)   NOT NULL,
    account_number      VARCHAR(20)  NOT NULL,
    pix_key             VARCHAR(255) NOT NULL,
    account_type        VARCHAR(255) NOT NULL,
    transaction_type    VARCHAR(255) NOT NULL,

    CONSTRAINT pk_bank_account PRIMARY KEY (id)
);