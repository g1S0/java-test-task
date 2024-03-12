CREATE TABLE audit_log (
    id SERIAL PRIMARY KEY,
    action_time TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    username VARCHAR(50),
    has_access BOOLEAN,
    request_params TEXT
);
