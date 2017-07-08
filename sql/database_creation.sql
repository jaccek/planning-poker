CREATE TABLE room (
    id INT NOT NULL auto_increment,
    name VARCHAR(10) NOT NULL UNIQUE,
    last_update TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE member (
    id INT NOT NULL auto_increment,
    name VARCHAR(20) NOT NULL,
    room_id INT NOT NULL,
    vote VARCHAR(5) DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (room_id)
        REFERENCES room(id)
        ON DELETE CASCADE
);
