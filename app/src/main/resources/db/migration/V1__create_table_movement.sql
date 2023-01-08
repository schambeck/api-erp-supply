CREATE TABLE "movement"
(
    id            UUID PRIMARY KEY,
    order_id      UUID           NOT NULL,
    issued_date   DATE           NOT NULL,
    order_line_id UUID           NOT NULL,
    product_id    UUID           NOT NULL,
    quantity      NUMERIC(12, 2) NOT NULL
);
