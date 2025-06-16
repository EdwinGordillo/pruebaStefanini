CREATE TABLE IF NOT EXISTS login_log (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    username VARCHAR(100) NOT NULL,
    login_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    access_token TEXT NOT NULL,
    refresh_token TEXT
);