CREATE TABLE user (
  id INTEGER NOT NULL,
  username TEXT NOT NULL,
  display_name TEXT,
  UNIQUE (username),
  PRIMARY KEY (id)
);

CREATE TABLE bleet (
  id INTEGER NOT NULL,
  author_id INTEGER NOT NULL,
  timestamp INTEGER NOT NULL DEFAULT (strftime('%s', 'now')),
  content TEXT NOT NULL,
  CONSTRAINT timestamp_format CHECK (timestamp IS strftime('%s', timestamp, 'unixepoch')),
  CONSTRAINT content_length CHECK (length(content) BETWEEN 1 AND 280),
  PRIMARY KEY (id),
  FOREIGN KEY (author_id) REFERENCES user (id)
);

CREATE INDEX ix_bleet_timestamp ON bleet (timestamp DESC);
CREATE INDEX ix_bleet_author_id ON bleet (author_id);
