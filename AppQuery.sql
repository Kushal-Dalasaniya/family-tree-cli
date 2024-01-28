CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT unique_name_constraint UNIQUE ("name")
);

-- Create the 'relation' table with a unique constraint
CREATE TABLE relation (
    id SERIAL PRIMARY KEY,
    main_person_id INTEGER REFERENCES person(id),
    second_person_id INTEGER REFERENCES person(id),
    relation_type VARCHAR(255) NOT NULL,
    CONSTRAINT unique_relation_constraint UNIQUE (main_person_id, second_person_id)
);