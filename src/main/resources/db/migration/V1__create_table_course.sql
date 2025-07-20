CREATE TABLE categories (
    id UUID PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE courses (
  id UUID PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  category_id UUID NOT NULL,
  active VARCHAR(10) NOT NULL DEFAULT 'ACTIVE',
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_category  FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE INDEX idx_courses_name ON courses (name);
CREATE INDEX idx_courses_category_id ON courses (category_id);
CREATE INDEX idx_courses_active ON courses (active);
