CREATE TABLE IF NOT EXISTS codes (
    id SERIAL PRIMARY KEY,
    "value" VARCHAR(20),
    created_at TIMESTAMP
);

INSERT INTO codes ("value", created_at) VALUES ('a0a0', now());
