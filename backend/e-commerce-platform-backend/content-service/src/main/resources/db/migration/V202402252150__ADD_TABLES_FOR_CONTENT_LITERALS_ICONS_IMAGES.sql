CREATE TABLE content_table (
  content_id INT,
   name VARCHAR(255),
   component INT,
   CONSTRAINT pk_content_table PRIMARY KEY (content_id)
);

CREATE TABLE icons (
  icon_id INT,
   component INT,
   icon_name VARCHAR(255),
   content_id INT,
   CONSTRAINT pk_icons PRIMARY KEY (icon_id)
);

ALTER TABLE icons ADD CONSTRAINT FK_ICONS_ON_CONTENT FOREIGN KEY (content_id) REFERENCES content_table (content_id) ON DELETE CASCADE;


CREATE TABLE images (
  image_id INT,
   component INT,
   image_url VARCHAR(255),
   image_name VARCHAR(255),
   content_id INT,
   CONSTRAINT pk_images PRIMARY KEY (image_id)
);

ALTER TABLE images ADD CONSTRAINT FK_IMAGES_ON_CONTENT FOREIGN KEY (content_id) REFERENCES content_table (content_id) ON DELETE CASCADE;


CREATE TABLE literals (
  literal_id INT,
   component INT,
   literal_value VARCHAR(255),
   literal_type VARCHAR(255),
   content_id INT,
   CONSTRAINT pk_literals PRIMARY KEY (literal_id)
);

ALTER TABLE literals ADD CONSTRAINT FK_LITERALS_ON_CONTENT FOREIGN KEY (content_id) REFERENCES content_table (content_id) ON DELETE CASCADE;

CREATE TABLE component (
    component_id INT NOT NULL,
    component_value VARCHAR(255) NOT NULL
);