-- Bảng res_company
CREATE TABLE res_company
(
    id   UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Bảng res_partner
CREATE TABLE res_partner
(
    id         UUID PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    company_id UUID REFERENCES res_company (id) ON DELETE CASCADE
);

-- Bảng product_category
CREATE TABLE product_category
(
    id        UUID PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    parent_id UUID          REFERENCES product_category (id) ON DELETE SET NULL,
    sequence  INT DEFAULT 0
);

-- Bảng uom_category
CREATE TABLE uom_category
(
    id   UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Bảng uom_uom
CREATE TABLE uom_uom
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    category_id UUID REFERENCES uom_category (id) ON DELETE CASCADE
);

-- Bảng product_template
CREATE TABLE product_template
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    category_id UUID          REFERENCES product_category (id) ON DELETE SET NULL,
    uom_id      UUID          REFERENCES uom_uom (id) ON DELETE SET NULL,
    type        VARCHAR(20)  NOT NULL CHECK (type IN ('consu', 'service', 'product'))
);

-- Bảng product_product
CREATE TABLE product_product
(
    id              UUID PRIMARY KEY,
    product_tmpl_id UUID REFERENCES product_template (id) ON DELETE CASCADE,
    active          BOOLEAN DEFAULT TRUE
);

-- Bảng product_attribute
CREATE TABLE product_attribute
(
    id   UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Bảng product_attribute_value
CREATE TABLE product_attribute_value
(
    id           UUID PRIMARY KEY,
    attribute_id UUID REFERENCES product_attribute (id) ON DELETE CASCADE,
    name         VARCHAR(255) NOT NULL
);

-- Bảng stock_location
CREATE TABLE stock_location
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    location_id UUID          REFERENCES stock_location (id) ON DELETE SET NULL,
    usage       VARCHAR(20)  NOT NULL CHECK (usage IN ('internal', 'supplier', 'customer', 'view'))
);

-- Bảng stock_warehouse
CREATE TABLE stock_warehouse
(
    id         UUID PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    company_id UUID REFERENCES res_company (id) ON DELETE CASCADE
);

-- Bảng stock_picking_type
CREATE TABLE stock_picking_type
(
    id           UUID PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    warehouse_id UUID REFERENCES stock_warehouse (id) ON DELETE CASCADE,
    code         VARCHAR(20)  NOT NULL CHECK (code IN ('incoming', 'outgoing', 'internal'))
);

-- Bảng stock_picking
CREATE TABLE stock_picking
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    picking_type_id UUID REFERENCES stock_picking_type (id) ON DELETE CASCADE,
    partner_id      UUID          REFERENCES res_partner (id) ON DELETE SET NULL,
    location_id     UUID          REFERENCES stock_location (id) ON DELETE SET NULL,
    state           VARCHAR(20)  NOT NULL CHECK (state IN ('draft', 'done'))
);

-- Bảng stock_move
CREATE TABLE stock_move
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    picking_id  UUID REFERENCES stock_picking (id) ON DELETE CASCADE,
    location_id UUID          REFERENCES stock_location (id) ON DELETE SET NULL,
    product_id  UUID REFERENCES product_product (id) ON DELETE CASCADE,
    state       VARCHAR(20)  NOT NULL CHECK (state IN ('draft', 'confirmed', 'done'))
);

-- Bảng stock_inventory
CREATE TABLE stock_inventory
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    location_id UUID          REFERENCES stock_location (id) ON DELETE SET NULL,
    state       VARCHAR(20)  NOT NULL CHECK (state IN ('draft', 'done'))
);

-- Bảng stock_quan
CREATE TABLE stock_quan
(
    id          UUID PRIMARY KEY,
    location_id UUID REFERENCES stock_location (id) ON DELETE CASCADE,
    product_id  UUID REFERENCES product_product (id) ON DELETE CASCADE,
    quantity    DECIMAL(10, 2) NOT NULL DEFAULT 0
);


CREATE TABLE product_attribute_line
(
    id           UUID PRIMARY KEY,
    product_id   UUID REFERENCES product_product (id) ON DELETE CASCADE,
    attribute_id UUID REFERENCES product_attribute (id) ON DELETE CASCADE,
    value_id     UUID REFERENCES product_attribute_value (id) ON DELETE CASCADE
);
