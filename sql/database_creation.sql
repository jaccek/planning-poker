CREATE TABLE room (
    id INT NOT NULL auto_increment,
    name VARCHAR(10) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE room_update (
    room_id INT NOT NULL,
    last_update TIMESTAMP NOT NULL,
    PRIMARY KEY (room_id),
    FOREIGN KEY (room_id)
        REFERENCES room(id)
        ON DELETE CASCADE
);

CREATE TABLE member (
    id INT NOT NULL auto_increment,
    name VARCHAR(20) NOT NULL,
    room_id INT NOT NULL,
    vote VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (room_id)
        REFERENCES room(id)
        ON DELETE CASCADE
);

CREATE TABLE member_update (
    member_id INT NOT NULL,
    last_update TIMESTAMP NOT NULL,
    PRIMARY KEY (member_id),
    FOREIGN KEY (member_id)
        REFERENCES member(id)
        ON DELETE CASCADE
);
