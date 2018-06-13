CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    display_name VARCHAR(1000),
    created_on TIMESTAMP WITH TIME ZONE,
    updated_on TIMESTAMP WITH TIME ZONE,
    deleted_on TIMESTAMP WITH TIME ZONE
);
