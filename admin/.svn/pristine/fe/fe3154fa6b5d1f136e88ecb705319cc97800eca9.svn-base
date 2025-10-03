
create table public.res_users
(
    id                uuid    not null
        primary key,
    company_id        uuid    not null,
    partner_id        uuid    not null,
    active            boolean default true,
    create_date       timestamp,
    login             varchar not null
        unique,
    password          varchar,
    create_uid        uuid
                              references public.res_users
                                  on delete set null,
    write_uid         uuid
                              references public.res_users
                                  on delete set null,
    signature         text,
    share             boolean,
    write_date        timestamp,
    totp_secret       varchar,
    tour_enabled      boolean,
    notification_type varchar not null,
    odoobot_state     varchar,
    odoobot_failed    boolean,
    action_id         uuid,
    constraint res_users_notification_type
        check (((notification_type)::text = 'email'::text) OR (NOT share))
);

comment on column public.res_users.create_uid is 'Created by';

comment on column public.res_users.write_uid is 'Last Updated by';

comment on column public.res_users.signature is 'Email Signature';

comment on column public.res_users.share is 'Share User';

comment on column public.res_users.write_date is 'Last Updated on';

comment on column public.res_users.tour_enabled is 'Onboarding';

comment on column public.res_users.notification_type is 'Notification';

comment on column public.res_users.odoobot_state is 'OdooBot Status';

comment on column public.res_users.odoobot_failed is 'Odoobot Failed';

comment on constraint res_users_notification_type on public.res_users is 'CHECK (notification_type = ''email'' OR NOT share)';



create table public.stock_location
(
    id                         uuid    not null
        primary key,
    location_id                uuid
                                       references public.stock_location
                                           on delete set null,
    posx                       integer,
    posy                       integer,
    posz                       integer,
    cyclic_inventory_frequency integer
        constraint stock_location_inventory_freq_nonneg
            check (cyclic_inventory_frequency >= 0),
    storage_category_id        uuid,
    create_uid                 uuid,
    write_uid                  uuid,
    name                       varchar not null,
    complete_name              varchar,
    usage                      varchar not null,
    parent_path                varchar,
    barcode                    varchar,
    last_inventory_date        date,
    next_inventory_date        date,
    comment                    text,
    active                     boolean,
    scrap_location             boolean,
    replenish_location         boolean,
    create_date                timestamp,
    write_date                 timestamp,
    warehouse_id               uuid,
    removal_strategy_id        uuid,
    company_id                 uuid,
    action_id                  uuid
);

comment on table public.stock_location is 'Inventory Locations';

comment on column public.stock_location.location_id is 'Parent Location';

comment on column public.stock_location.posx is 'Corridor (X)';

comment on column public.stock_location.posy is 'Shelves (Y)';

comment on column public.stock_location.posz is 'Height (Z)';

comment on column public.stock_location.cyclic_inventory_frequency is 'Inventory Frequency';

comment on constraint stock_location_inventory_freq_nonneg on public.stock_location is 'check(cyclic_inventory_frequency >= 0)';

comment on column public.stock_location.storage_category_id is 'Storage Category';

comment on column public.stock_location.create_uid is 'Created by';

comment on column public.stock_location.write_uid is 'Last Updated by';

comment on column public.stock_location.name is 'Location Name';

comment on column public.stock_location.complete_name is 'Full Location Name';

comment on column public.stock_location.usage is 'Location Type';

comment on column public.stock_location.parent_path is 'Parent Path';

comment on column public.stock_location.barcode is 'Barcode';

comment on column public.stock_location.last_inventory_date is 'Last Inventory';

comment on column public.stock_location.next_inventory_date is 'Next Expected';

comment on column public.stock_location.comment is 'Additional Information';

comment on column public.stock_location.active is 'Active';

comment on column public.stock_location.scrap_location is 'Is a Scrap Location?';

comment on column public.stock_location.replenish_location is 'Replenish Location';

comment on column public.stock_location.create_date is 'Created on';

comment on column public.stock_location.write_date is 'Last Updated on';

comment on column public.stock_location.warehouse_id is 'Ware house
';


create table public.stock_package_level
(
    id               uuid not null
        primary key,
    package_id       uuid not null,
    picking_id       uuid,
    location_dest_id uuid
                          references public.stock_location
                              on delete set null,
    company_id       uuid not null,
    create_uid       uuid,
    write_uid        uuid,
    create_date      timestamp,
    write_date       timestamp
);

comment on table public.stock_package_level is 'Stock Package Level';

comment on column public.stock_package_level.package_id is 'Package';

comment on column public.stock_package_level.picking_id is 'Picking';

comment on column public.stock_package_level.location_dest_id is 'To';

comment on column public.stock_package_level.company_id is 'Company';

comment on column public.stock_package_level.create_uid is 'Created by';

comment on column public.stock_package_level.write_uid is 'Last Updated by';

comment on column public.stock_package_level.create_date is 'Created on';

comment on column public.stock_package_level.write_date is 'Last Updated on';



create table public.stock_package_type
(
    id               uuid    not null
        primary key,

    company_id       uuid,
    create_uid       uuid,
    write_uid        uuid,
    name             varchar not null,
    barcode          varchar
        constraint stock_package_type_barcode_uniq
            unique,
    create_date      timestamp,
    write_date       timestamp,
    height           double precision
        constraint stock_package_type_positive_height
            check (height >= (0.0)::double precision),
    width            double precision
        constraint stock_package_type_positive_width
            check (width >= (0.0)::double precision),
    packaging_length double precision
        constraint stock_package_type_positive_length
            check (packaging_length >= (0.0)::double precision),
    base_weight      double precision,
    max_weight       double precision
        constraint stock_package_type_positive_max_weight
            check (max_weight >= (0.0)::double precision)
);

comment on table public.stock_package_type is 'Stock package type';


comment on column public.stock_package_type.company_id is 'Company';

comment on column public.stock_package_type.create_uid is 'Created by';

comment on column public.stock_package_type.write_uid is 'Last Updated by';

comment on column public.stock_package_type.name is 'Package Type';

comment on column public.stock_package_type.barcode is 'Barcode';

comment on constraint stock_package_type_barcode_uniq on public.stock_package_type is 'unique(barcode)';

comment on column public.stock_package_type.create_date is 'Created on';

comment on column public.stock_package_type.write_date is 'Last Updated on';

comment on column public.stock_package_type.height is 'Height';

comment on constraint stock_package_type_positive_height on public.stock_package_type is 'CHECK(height>=0.0)';

comment on column public.stock_package_type.width is 'Width';

comment on constraint stock_package_type_positive_width on public.stock_package_type is 'CHECK(width>=0.0)';

comment on column public.stock_package_type.packaging_length is 'Length';

comment on constraint stock_package_type_positive_length on public.stock_package_type is 'CHECK(packaging_length>=0.0)';

comment on column public.stock_package_type.base_weight is 'Weight';

comment on column public.stock_package_type.max_weight is 'Max Weight';

comment on constraint stock_package_type_positive_max_weight on public.stock_package_type is 'CHECK(max_weight>=0.0)';


create table public.stock_picking
(
    id                 uuid    not null
        primary key,
    backorder_id       uuid
                               references public.stock_picking
                                   on delete set null,
    return_id          uuid
                               references public.stock_picking
                                   on delete set null,
    group_id           uuid,
    location_id        uuid    not null
        references public.stock_location
            on delete restrict,
    location_dest_id   uuid    not null
        references public.stock_location
            on delete restrict,
    picking_type_id    uuid    not null,
    partner_id         uuid,
    company_id         uuid,
    user_id            uuid,
    owner_id           uuid,
    create_uid         uuid,
    write_uid          uuid,
    name               varchar,
    origin             varchar,
    move_type          varchar not null,
    state              varchar,
    priority           varchar,
    picking_properties jsonb,
    note               text,
    has_deadline_issue boolean,
    printed            boolean,
    is_locked          boolean,
    scheduled_date     timestamp,
    date_deadline      timestamp,
    date               timestamp,
    date_done          timestamp,
    create_date        timestamp,
    write_date         timestamp,
    constraint stock_picking_name_uniq
        unique (name, company_id)
);

comment on table public.stock_picking is 'Transfer';

comment on column public.stock_picking.backorder_id is 'Back Order of';

comment on column public.stock_picking.return_id is 'Return of';

comment on column public.stock_picking.group_id is 'Procurement Group';

comment on column public.stock_picking.location_id is 'Source Location';

comment on column public.stock_picking.location_dest_id is 'Destination Location';

comment on column public.stock_picking.picking_type_id is 'Operation Type';

comment on column public.stock_picking.partner_id is 'Contact';

comment on column public.stock_picking.company_id is 'Company';

comment on column public.stock_picking.user_id is 'Responsible';

comment on column public.stock_picking.owner_id is 'Assign Owner';

comment on column public.stock_picking.create_uid is 'Created by';

comment on column public.stock_picking.write_uid is 'Last Updated by';

comment on column public.stock_picking.name is 'Reference';

comment on column public.stock_picking.origin is 'Source Document';

comment on column public.stock_picking.move_type is 'Shipping Policy';

comment on column public.stock_picking.state is 'Status';

comment on column public.stock_picking.priority is 'Priority';

comment on column public.stock_picking.picking_properties is 'Properties';

comment on column public.stock_picking.note is 'Notes';

comment on column public.stock_picking.has_deadline_issue is 'Is late';

comment on column public.stock_picking.printed is 'Printed';

comment on column public.stock_picking.is_locked is 'Is Locked';

comment on column public.stock_picking.scheduled_date is 'Scheduled Date';

comment on column public.stock_picking.date_deadline is 'Deadline';

comment on column public.stock_picking.date is 'Creation Date';

comment on column public.stock_picking.date_done is 'Date of Transfer';

comment on column public.stock_picking.create_date is 'Created on';

comment on column public.stock_picking.write_date is 'Last Updated on';

comment on constraint stock_picking_name_uniq on public.stock_picking is 'unique(name, company_id)';


create table public.stock_picking_type
(
    id                                 uuid    not null
        primary key,
    color                              integer,

    default_location_src_id            uuid    not null
        references public.stock_location
            on delete restrict,
    default_location_dest_id           uuid    not null
        references public.stock_location
            on delete restrict,
    return_picking_type_id             uuid
                                               references public.stock_picking_type
                                                   on delete set null,
    reservation_days_before            integer,
    reservation_days_before_priority   integer,
    company_id                         uuid    not null,
    create_uid                         uuid,
    write_uid                          uuid,

    code                               varchar not null,
    reservation_method                 varchar not null,
    product_label_format               varchar,
    lot_label_format                   varchar,
    package_label_to_print             varchar,
    barcode                            varchar,
    create_backorder                   varchar not null,
    move_type                          varchar not null,
    name                               jsonb   not null,
    picking_properties_definition      jsonb,
    show_entire_packs                  boolean,
    active                             boolean,
    use_create_lots                    boolean,
    use_existing_lots                  boolean,
    print_label                        boolean,
    show_operations                    boolean,
    auto_show_reception_report         boolean,
    auto_print_delivery_slip           boolean,
    auto_print_return_slip             boolean,
    auto_print_product_labels          boolean,
    auto_print_lot_labels              boolean,
    auto_print_reception_report        boolean,
    auto_print_reception_report_labels boolean,
    auto_print_packages                boolean,
    auto_print_package_label           boolean,
    create_date                        timestamp,
    write_date                         timestamp,
    warehouse_id                       uuid
);

comment on table public.stock_picking_type is 'Picking Type';

comment on column public.stock_picking_type.color is 'Color';


comment on column public.stock_picking_type.default_location_src_id is 'Source Location';

comment on column public.stock_picking_type.default_location_dest_id is 'Destination Location';

comment on column public.stock_picking_type.return_picking_type_id is 'Operation Type for Returns';

comment on column public.stock_picking_type.reservation_days_before is 'Days';

comment on column public.stock_picking_type.reservation_days_before_priority is 'Days when starred';

comment on column public.stock_picking_type.company_id is 'Company';

comment on column public.stock_picking_type.create_uid is 'Created by';

comment on column public.stock_picking_type.write_uid is 'Last Updated by';


comment on column public.stock_picking_type.code is 'Type of Operation';

comment on column public.stock_picking_type.reservation_method is 'Reservation Method';

comment on column public.stock_picking_type.product_label_format is 'Product Label Format to auto-print';

comment on column public.stock_picking_type.lot_label_format is 'Lot Label Format to auto-print';

comment on column public.stock_picking_type.package_label_to_print is 'Package Label to Print';

comment on column public.stock_picking_type.barcode is 'Barcode';

comment on column public.stock_picking_type.create_backorder is 'Create Backorder';

comment on column public.stock_picking_type.move_type is 'Shipping Policy';

comment on column public.stock_picking_type.name is 'Operation Type';

comment on column public.stock_picking_type.picking_properties_definition is 'Picking Properties';

comment on column public.stock_picking_type.show_entire_packs is 'Move Entire Packages';

comment on column public.stock_picking_type.active is 'Active';

comment on column public.stock_picking_type.use_create_lots is 'Create New Lots/Serial Numbers';

comment on column public.stock_picking_type.use_existing_lots is 'Use Existing Lots/Serial Numbers';

comment on column public.stock_picking_type.print_label is 'Generate Shipping Labels';

comment on column public.stock_picking_type.show_operations is 'Show Detailed Operations';

comment on column public.stock_picking_type.auto_show_reception_report is 'Show Reception Report at Validation';

comment on column public.stock_picking_type.auto_print_delivery_slip is 'Auto Print Delivery Slip';

comment on column public.stock_picking_type.auto_print_return_slip is 'Auto Print Return Slip';

comment on column public.stock_picking_type.auto_print_product_labels is 'Auto Print Product Labels';

comment on column public.stock_picking_type.auto_print_lot_labels is 'Auto Print Lot/SN Labels';

comment on column public.stock_picking_type.auto_print_reception_report is 'Auto Print Reception Report';

comment on column public.stock_picking_type.auto_print_reception_report_labels is 'Auto Print Reception Report Labels';

comment on column public.stock_picking_type.auto_print_packages is 'Auto Print Packages';

comment on column public.stock_picking_type.auto_print_package_label is 'Auto Print Package Label';

comment on column public.stock_picking_type.create_date is 'Created on';

comment on column public.stock_picking_type.write_date is 'Last Updated on';

comment on column public.stock_picking_type.warehouse_id is 'Ware house';


create table public.stock_warehouse
(
    id                     uuid       not null
        primary key,
    company_id             uuid       not null,
    partner_id             uuid,
    view_location_id       uuid       not null,
    lot_stock_id           uuid       not null,
    wh_input_stock_loc_id  uuid,
    wh_qc_stock_loc_id     uuid,
    wh_output_stock_loc_id uuid,
    wh_pack_stock_loc_id   uuid,
    mto_pull_id            uuid,
    pick_type_id           uuid,
    pack_type_id           uuid,
    out_type_id            uuid,
    in_type_id             uuid,
    int_type_id            uuid,
    qc_type_id             uuid,
    store_type_id          uuid,
    xdock_type_id          uuid,
    crossdock_route_id     uuid,
    reception_route_id     uuid,
    delivery_route_id      uuid,
    create_uid             uuid,
    write_uid              uuid,
    name                   varchar    not null,
    code                   varchar(5) not null,
    reception_steps        varchar    not null,
    delivery_steps         varchar    not null,
    active                 boolean,
    create_date            timestamp,
    write_date             timestamp,
    constraint stock_warehouse_warehouse_name_uniq
        unique (name, company_id),
    constraint stock_warehouse_warehouse_code_uniq
        unique (code, company_id)
);

comment on table public.stock_warehouse is 'Warehouse';

comment on column public.stock_warehouse.company_id is 'Company';

comment on column public.stock_warehouse.partner_id is 'Address';

comment on column public.stock_warehouse.view_location_id is 'View Location';

comment on column public.stock_warehouse.lot_stock_id is 'Location Stock';

comment on column public.stock_warehouse.wh_input_stock_loc_id is 'Input Location';

comment on column public.stock_warehouse.wh_qc_stock_loc_id is 'Quality Control Location';

comment on column public.stock_warehouse.wh_output_stock_loc_id is 'Output Location';

comment on column public.stock_warehouse.wh_pack_stock_loc_id is 'Packing Location';

comment on column public.stock_warehouse.mto_pull_id is 'MTO rule';

comment on column public.stock_warehouse.pick_type_id is 'Pick Type';

comment on column public.stock_warehouse.pack_type_id is 'Pack Type';

comment on column public.stock_warehouse.out_type_id is 'Out Type';

comment on column public.stock_warehouse.in_type_id is 'In Type';

comment on column public.stock_warehouse.int_type_id is 'Internal Type';

comment on column public.stock_warehouse.qc_type_id is 'Quality Control Type';

comment on column public.stock_warehouse.store_type_id is 'Storage Type';

comment on column public.stock_warehouse.xdock_type_id is 'Cross Dock Type';

comment on column public.stock_warehouse.crossdock_route_id is 'Crossdock Route';

comment on column public.stock_warehouse.reception_route_id is 'Receipt Route';

comment on column public.stock_warehouse.delivery_route_id is 'Delivery Route';

comment on column public.stock_warehouse.create_uid is 'Created by';

comment on column public.stock_warehouse.write_uid is 'Last Updated by';

comment on column public.stock_warehouse.name is 'Warehouse';

comment on column public.stock_warehouse.code is 'Short Name';

comment on column public.stock_warehouse.reception_steps is 'Incoming Shipments';

comment on column public.stock_warehouse.delivery_steps is 'Outgoing Shipments';

comment on column public.stock_warehouse.active is 'Active';

comment on column public.stock_warehouse.create_date is 'Created on';

comment on column public.stock_warehouse.write_date is 'Last Updated on';

comment on constraint stock_warehouse_warehouse_name_uniq on public.stock_warehouse is 'unique(name, company_id)';

comment on constraint stock_warehouse_warehouse_code_uniq on public.stock_warehouse is 'unique(code, company_id)';

create table public.uom_category
(
    id          uuid  not null
        primary key,
    create_uid  uuid
                      references public.res_users
                          on delete set null,
    write_uid   uuid
                      references public.res_users
                          on delete set null,
    name        jsonb not null,
    create_date timestamp,
    write_date  timestamp
);

comment on table public.uom_category is 'Product UoM Categories';

comment on column public.uom_category.create_uid is 'Created by';

comment on column public.uom_category.write_uid is 'Last Updated by';

comment on column public.uom_category.name is 'Unit of Measure Category';

comment on column public.uom_category.create_date is 'Created on';

comment on column public.uom_category.write_date is 'Last Updated on';

create table public.uom_uom
(
    id          uuid    not null
        primary key,
    category_id uuid    not null
        references public.uom_category
            on delete restrict,
    create_uid  uuid
                        references public.res_users
                            on delete set null,
    write_uid   uuid
                        references public.res_users
                            on delete set null,
    uom_type    varchar not null,
    name        jsonb   not null,
    factor      numeric not null
        constraint uom_uom_factor_gt_zero
            check (factor <> (0)::numeric),
    rounding    numeric not null
        constraint uom_uom_rounding_gt_zero
            check (rounding > (0)::numeric),
    active      boolean,
    create_date timestamp,
    write_date  timestamp,
    constraint uom_uom_factor_reference_is_one
        check ((((uom_type)::text = 'reference'::text) AND (factor = 1.0)) OR ((uom_type)::text <> 'reference'::text))
);

create table public.barcode_rule
(
    id                      uuid    not null
        primary key,
    barcode_nomenclature_id uuid,
    create_uid              uuid
                                    references public.res_users
                                        on delete set null,
    write_uid               uuid
                                    references public.res_users
                                        on delete set null,
    name                    varchar not null,
    encoding                varchar not null,
    type                    varchar not null,
    pattern                 varchar not null,
    alias                   varchar not null,
    create_date             timestamp,
    write_date              timestamp,
    associated_uom_id       uuid
                                    references public.uom_uom
                                        on delete set null,
    gs1_content_type        varchar,
    gs1_decimal_usage       boolean
);

comment on table public.barcode_rule is 'Barcode Rule';

comment on column public.barcode_rule.barcode_nomenclature_id is 'Barcode Nomenclature';

comment on column public.barcode_rule.create_uid is 'Created by';

comment on column public.barcode_rule.write_uid is 'Last Updated by';

comment on column public.barcode_rule.name is 'Rule Name';

comment on column public.barcode_rule.encoding is 'Encoding';

comment on column public.barcode_rule.type is 'Type';

comment on column public.barcode_rule.pattern is 'Barcode Pattern';

comment on column public.barcode_rule.alias is 'Alias';

comment on column public.barcode_rule.create_date is 'Created on';

comment on column public.barcode_rule.write_date is 'Last Updated on';

comment on column public.barcode_rule.associated_uom_id is 'Associated Uom';

comment on column public.barcode_rule.gs1_content_type is 'GS1 Content Type';

comment on column public.barcode_rule.gs1_decimal_usage is 'Decimal';



create table public.product_attribute
(
    id             uuid    not null
        primary key,
    create_uid     uuid
                           references public.res_users
                               on delete set null,
    write_uid      uuid
                           references public.res_users
                               on delete set null,
    create_variant varchar not null,
    display_type   varchar not null,
    name           jsonb   not null,
    active         boolean,
    create_date    timestamp,
    write_date     timestamp,
    constraint product_attribute_check_multi_checkbox_no_variant
        check (((display_type)::text <> 'multi'::text) OR ((create_variant)::text = 'no_variant'::text))
);

comment on table public.product_attribute is 'Product Attribute';

comment on column public.product_attribute.create_uid is 'Created by';

comment on column public.product_attribute.write_uid is 'Last Updated by';

comment on column public.product_attribute.create_variant is 'Variant Creation';

comment on column public.product_attribute.display_type is 'Display Type';

comment on column public.product_attribute.name is 'Attribute';

comment on column public.product_attribute.active is 'Active';

comment on column public.product_attribute.create_date is 'Created on';

comment on column public.product_attribute.write_date is 'Last Updated on';

comment on constraint product_attribute_check_multi_checkbox_no_variant on public.product_attribute is 'CHECK(display_type != ''multi'' OR create_variant = ''no_variant'')';


create table public.product_removal
(
    id          uuid  not null
        primary key,
    create_uid  uuid
                      references public.res_users
                          on delete set null,
    write_uid   uuid
                      references public.res_users
                          on delete set null,
    name        jsonb not null,
    method      jsonb not null,
    create_date timestamp,
    write_date  timestamp
);

comment on table public.product_removal is 'Removal Strategy';

comment on column public.product_removal.create_uid is 'Created by';

comment on column public.product_removal.write_uid is 'Last Updated by';

comment on column public.product_removal.name is 'Name';

comment on column public.product_removal.method is 'Method';

comment on column public.product_removal.create_date is 'Created on';

comment on column public.product_removal.write_date is 'Last Updated on';



create table public.product_category
(
    id                            uuid    not null
        primary key,
    parent_id                     uuid
        references public.product_category
            on delete cascade,
    create_uid                    uuid
                                          references public.res_users
                                              on delete set null,
    write_uid                     uuid
                                          references public.res_users
                                              on delete set null,
    name                          varchar not null,
    complete_name                 varchar,
    parent_path                   varchar,
    product_properties_definition jsonb,
    create_date                   timestamp,
    write_date                    timestamp,
    removal_strategy_id           uuid
                                          references public.product_removal
                                              on delete set null,
    packaging_reserve_method      varchar
);

comment on table public.product_category is 'Product Category';

comment on column public.product_category.parent_id is 'Parent Category';

comment on column public.product_category.create_uid is 'Created by';

comment on column public.product_category.write_uid is 'Last Updated by';

comment on column public.product_category.name is 'Name';

comment on column public.product_category.complete_name is 'Complete Name';

comment on column public.product_category.parent_path is 'Parent Path';

comment on column public.product_category.product_properties_definition is 'Product Properties';

comment on column public.product_category.create_date is 'Created on';

comment on column public.product_category.write_date is 'Last Updated on';

comment on column public.product_category.removal_strategy_id is 'Force Removal Strategy';

comment on column public.product_category.packaging_reserve_method is 'Reserve Packagings';


create table public.res_currency
(
    id                     uuid    not null
        primary key,
    name                   varchar not null
        constraint res_currency_unique_name
            unique,
    symbol                 varchar not null,
    iso_numeric            integer,
    decimal_places         integer,
    create_uid             uuid
                                   references public.res_users
                                       on delete set null,
    write_uid              uuid
                                   references public.res_users
                                       on delete set null,
    full_name              varchar,
    position               varchar,
    currency_unit_label    jsonb,
    currency_subunit_label jsonb,
    rounding               numeric
        constraint res_currency_rounding_gt_zero
            check (rounding > (0)::numeric),
    active                 boolean,
    create_date            timestamp,
    write_date             timestamp
);

comment on constraint res_currency_unique_name on public.res_currency is 'unique (name)';

comment on column public.res_currency.iso_numeric is 'Currency numeric code.';

comment on column public.res_currency.decimal_places is 'Decimal Places';

comment on column public.res_currency.create_uid is 'Created by';

comment on column public.res_currency.write_uid is 'Last Updated by';

comment on column public.res_currency.full_name is 'Name';

comment on column public.res_currency.position is 'Symbol Position';

comment on column public.res_currency.currency_unit_label is 'Currency Unit';

comment on column public.res_currency.currency_subunit_label is 'Currency Subunit';

comment on column public.res_currency.rounding is 'Rounding Factor';

comment on constraint res_currency_rounding_gt_zero on public.res_currency is 'CHECK (rounding>0)';

comment on column public.res_currency.active is 'Active';

comment on column public.res_currency.create_date is 'Created on';

comment on column public.res_currency.write_date is 'Last Updated on';

create table public.res_company
(
    id                                  uuid    not null
        primary key,
    name                                varchar not null
        constraint res_company_name_uniq
            unique,
    partner_id                          uuid    not null,
    currency_id                         uuid    not null
        references public.res_currency
            on delete restrict,
    create_date                         timestamp,
    parent_path                         varchar,
    parent_id                           uuid
        references public.res_company
            on delete restrict,
    paperformat_id                      uuid,
    external_report_layout_id           uuid,
    create_uid                          uuid
                                                references public.res_users
                                                    on delete set null,
    write_uid                           uuid
                                                references public.res_users
                                                    on delete set null,
    email                               varchar,
    phone                               varchar,
    mobile                              varchar,
    font                                varchar,
    primary_color                       varchar,
    secondary_color                     varchar,
    layout_background                   varchar not null,
    report_header                       jsonb,
    report_footer                       jsonb,
    company_details                     jsonb,
    active                              boolean,
    uses_default_logo                   boolean,
    write_date                          timestamp,
    logo_web                            bytea,
    nomenclature_id                     uuid,
    resource_calendar_id                uuid,
    alias_domain_id                     uuid,
    alias_domain_name                   varchar,
    email_primary_color                 varchar,
    email_secondary_color               varchar,
    partner_gid                         integer,
    iap_enrich_auto_done                boolean,
    snailmail_color                     boolean,
    snailmail_cover                     boolean,
    snailmail_duplex                    boolean,
    internal_transit_location_id        uuid
        references public.stock_location
            on delete restrict,
    stock_mail_confirmation_template_id uuid,
    annual_inventory_day                integer,
    annual_inventory_month              varchar,
    stock_move_email_validation         boolean,
    stock_sms_confirmation_template_id  uuid,
    stock_move_sms_validation           boolean,
    has_received_warning_stock_sms      boolean
);

comment on constraint res_company_name_uniq on public.res_company is 'unique (name)';

comment on column public.res_company.parent_id is 'Parent Company';

comment on column public.res_company.paperformat_id is 'Paper format';

comment on column public.res_company.external_report_layout_id is 'Document Template';

comment on column public.res_company.create_uid is 'Created by';

comment on column public.res_company.write_uid is 'Last Updated by';

comment on column public.res_company.email is 'Email';

comment on column public.res_company.phone is 'Phone';

comment on column public.res_company.mobile is 'Mobile';

comment on column public.res_company.font is 'Font';

comment on column public.res_company.primary_color is 'Primary Color';

comment on column public.res_company.secondary_color is 'Secondary Color';

comment on column public.res_company.layout_background is 'Layout Background';

comment on column public.res_company.report_header is 'Company Tagline';

comment on column public.res_company.report_footer is 'Report Footer';

comment on column public.res_company.company_details is 'Company Details';

comment on column public.res_company.active is 'Active';

comment on column public.res_company.uses_default_logo is 'Uses Default Logo';

comment on column public.res_company.write_date is 'Last Updated on';

comment on column public.res_company.logo_web is 'Logo Web';

comment on column public.res_company.nomenclature_id is 'Nomenclature';

comment on column public.res_company.resource_calendar_id is 'Default Working Hours';

comment on column public.res_company.alias_domain_id is 'Email Domain';

comment on column public.res_company.alias_domain_name is 'Alias Domain Name';

comment on column public.res_company.email_primary_color is 'Email Header Color';

comment on column public.res_company.email_secondary_color is 'Email Button Color';

comment on column public.res_company.partner_gid is 'Company database ID';

comment on column public.res_company.iap_enrich_auto_done is 'Enrich Done';

comment on column public.res_company.snailmail_color is 'Snailmail Color';

comment on column public.res_company.snailmail_cover is 'Add a Cover Page';

comment on column public.res_company.snailmail_duplex is 'Both sides';

comment on column public.res_company.internal_transit_location_id is 'Internal Transit Location';

comment on column public.res_company.stock_mail_confirmation_template_id is 'Email Template confirmation picking';

comment on column public.res_company.annual_inventory_day is 'Day of the month';

comment on column public.res_company.annual_inventory_month is 'Annual Inventory Month';

comment on column public.res_company.stock_move_email_validation is 'Email Confirmation picking';

comment on column public.res_company.stock_sms_confirmation_template_id is 'SMS Template';

comment on column public.res_company.stock_move_sms_validation is 'SMS Confirmation';

comment on column public.res_company.has_received_warning_stock_sms is 'Has Received Warning Stock Sms';


create table public.stock_route
(
    id                       uuid  not null
        primary key,
    supplied_wh_id           uuid
                                   references public.stock_warehouse
                                       on delete set null,
    supplier_wh_id           uuid
                                   references public.stock_warehouse
                                       on delete set null,
    company_id               uuid
                                   references public.res_company
                                       on delete set null,
    create_uid               uuid
                                   references public.res_users
                                       on delete set null,
    write_uid                uuid
                                   references public.res_users
                                       on delete set null,
    name                     jsonb not null,
    active                   boolean,
    product_selectable       boolean,
    product_categ_selectable boolean,
    warehouse_selectable     boolean,
    packaging_selectable     boolean,
    create_date              timestamp,
    write_date               timestamp
);

comment on table public.stock_route is 'Inventory Routes';

comment on column public.stock_route.supplied_wh_id is 'Supplied Warehouse';

comment on column public.stock_route.supplier_wh_id is 'Supplying Warehouse';

comment on column public.stock_route.company_id is 'Company';

comment on column public.stock_route.create_uid is 'Created by';

comment on column public.stock_route.write_uid is 'Last Updated by';

comment on column public.stock_route.name is 'Route';

comment on column public.stock_route.active is 'Active';

comment on column public.stock_route.product_selectable is 'Applicable on Product';

comment on column public.stock_route.product_categ_selectable is 'Applicable on Product Category';

comment on column public.stock_route.warehouse_selectable is 'Applicable on Warehouse';

comment on column public.stock_route.packaging_selectable is 'Applicable on Packaging';

comment on column public.stock_route.create_date is 'Created on';

comment on column public.stock_route.write_date is 'Last Updated on';

create table public.res_partner
(
    id                                  uuid not null
        primary key,
    company_id                          uuid
                                             references public.res_company
                                                 on delete set null,
    create_date                         timestamp,
    name                                varchar,
    title                               uuid,
    parent_id                           uuid
                                             references public.res_partner
                                                 on delete set null,
    user_id                             uuid
                                             references public.res_users
                                                 on delete set null,
    state_id                            uuid,
    country_id                          uuid,
    industry_id                         uuid,
    color                               integer,
    commercial_partner_id               uuid
                                             references public.res_partner
                                                 on delete set null,
    create_uid                          uuid
                                             references public.res_users
                                                 on delete set null,
    write_uid                           uuid
                                             references public.res_users
                                                 on delete set null,
    complete_name                       varchar,
    ref                                 varchar,
    lang                                varchar,
    tz                                  varchar,
    vat                                 varchar,
    company_registry                    varchar,
    website                             varchar,
    function                            varchar,
    type                                varchar,
    street                              varchar,
    street2                             varchar,
    zip                                 varchar,
    city                                varchar,
    email                               varchar,
    phone                               varchar,
    mobile                              varchar,
    commercial_company_name             varchar,
    company_name                        varchar,
    barcode                             jsonb,
    comment                             text,
    partner_latitude                    numeric,
    partner_longitude                   numeric,
    active                              boolean,
    employee                            boolean,
    is_company                          boolean,
    partner_share                       boolean,
    write_date                          timestamp,
    message_bounce                      integer,
    email_normalized                    varchar,
    signup_type                         varchar,
    specific_property_product_pricelist jsonb,
    partner_gid                         integer,
    additional_info                     varchar,
    phone_sanitized                     varchar,
    picking_warn                        varchar,
    property_stock_customer             jsonb,
    property_stock_supplier             jsonb,
    picking_warn_msg                    text,
    constraint res_partner_check_name
        check ((((type)::text = 'contact'::text) AND (name IS NOT NULL)) OR ((type)::text <> 'contact'::text))
);

comment on column public.res_partner.title is 'Title';

comment on column public.res_partner.parent_id is 'Related Company';

comment on column public.res_partner.user_id is 'Salesperson';

comment on column public.res_partner.state_id is 'State';

comment on column public.res_partner.country_id is 'Country';

comment on column public.res_partner.industry_id is 'Industry';

comment on column public.res_partner.color is 'Color Index';

comment on column public.res_partner.commercial_partner_id is 'Commercial Entity';

comment on column public.res_partner.create_uid is 'Created by';

comment on column public.res_partner.write_uid is 'Last Updated by';

comment on column public.res_partner.complete_name is 'Complete Name';

comment on column public.res_partner.ref is 'Reference';

comment on column public.res_partner.lang is 'Language';

comment on column public.res_partner.tz is 'Timezone';

comment on column public.res_partner.vat is 'Tax ID';

comment on column public.res_partner.company_registry is 'Company ID';

comment on column public.res_partner.website is 'Website Link';

comment on column public.res_partner.function is 'Job Position';

comment on column public.res_partner.type is 'Address Type';

comment on column public.res_partner.street is 'Street';

comment on column public.res_partner.street2 is 'Street2';

comment on column public.res_partner.zip is 'Zip';

comment on column public.res_partner.city is 'City';

comment on column public.res_partner.email is 'Email';

comment on column public.res_partner.phone is 'Phone';

comment on column public.res_partner.mobile is 'Mobile';

comment on column public.res_partner.commercial_company_name is 'Company Name Entity';

comment on column public.res_partner.company_name is 'Company Name';

comment on column public.res_partner.barcode is 'Barcode';

comment on column public.res_partner.comment is 'Notes';

comment on column public.res_partner.partner_latitude is 'Geo Latitude';

comment on column public.res_partner.partner_longitude is 'Geo Longitude';

comment on column public.res_partner.active is 'Active';

comment on column public.res_partner.employee is 'Employee';

comment on column public.res_partner.is_company is 'Is a Company';

comment on column public.res_partner.partner_share is 'Share Partner';

comment on column public.res_partner.write_date is 'Last Updated on';

comment on column public.res_partner.message_bounce is 'Bounce';

comment on column public.res_partner.email_normalized is 'Normalized Email';

comment on column public.res_partner.signup_type is 'Signup Token Type';

comment on column public.res_partner.specific_property_product_pricelist is 'Specific Property Product Pricelist';

comment on column public.res_partner.partner_gid is 'Company database ID';

comment on column public.res_partner.additional_info is 'Additional info';

comment on column public.res_partner.phone_sanitized is 'Sanitized Number';

comment on column public.res_partner.picking_warn is 'Stock Picking';

comment on column public.res_partner.property_stock_customer is 'Customer Location';

comment on column public.res_partner.property_stock_supplier is 'Vendor Location';

comment on column public.res_partner.picking_warn_msg is 'Message for Stock Picking';

comment on constraint res_partner_check_name on public.res_partner is 'CHECK( (type=''contact'' AND name IS NOT NULL) or (type!=''contact'') )';

create table public.procurement_group
(
    id          uuid    not null
        primary key,
    partner_id  uuid
                        references public.res_partner
                            on delete set null,
    create_uid  uuid
                        references public.res_users
                            on delete set null,
    write_uid   uuid
                        references public.res_users
                            on delete set null,
    name        varchar not null,
    move_type   varchar,
    create_date timestamp,
    write_date  timestamp
);

comment on table public.procurement_group is 'Procurement Group';

comment on column public.procurement_group.partner_id is 'Partner';

comment on column public.procurement_group.create_uid is 'Created by';

comment on column public.procurement_group.write_uid is 'Last Updated by';

comment on column public.procurement_group.name is 'Reference';

comment on column public.procurement_group.move_type is 'Delivery Type';

comment on column public.procurement_group.create_date is 'Created on';

comment on column public.procurement_group.write_date is 'Last Updated on';

create table public.stock_rule
(
    id                       uuid    not null
        primary key,
    group_id                 uuid,
    company_id               uuid
                                     references public.res_company
                                         on delete set null,
    location_dest_id         uuid    not null
        references public.stock_location
            on delete restrict,
    location_src_id          uuid
                                     references public.stock_location
                                         on delete set null,
    route_id                 uuid    not null,

    picking_type_id          uuid    not null
        references public.stock_picking_type
            on delete restrict,
    delay                    uuid,
    partner_address_id       uuid,
    propagate_warehouse_id   uuid,
    create_uid               uuid
                                     references public.res_users
                                         on delete set null,
    write_uid                uuid
                                     references public.res_users
                                         on delete set null,
    group_propagation_option varchar,
    action                   varchar not null,
    procure_method           varchar not null,
    auto                     varchar not null,
    push_domain              varchar,
    name                     jsonb   not null,
    active                   boolean,
    location_dest_from_rule  boolean,
    propagate_cancel         boolean,
    propagate_carrier        boolean,
    create_date              timestamp,
    write_date               timestamp,
    warehouse_id             uuid
);

comment on table public.stock_rule is 'Stock Rule';

comment on column public.stock_rule.group_id is 'Fixed Procurement Group';


comment on column public.stock_rule.company_id is 'Company';

comment on column public.stock_rule.location_dest_id is 'Destination Location';

comment on column public.stock_rule.location_src_id is 'Source Location';

comment on column public.stock_rule.route_id is 'Route';

comment on column public.stock_rule.picking_type_id is 'Operation Type';

comment on column public.stock_rule.delay is 'Lead Time';

comment on column public.stock_rule.partner_address_id is 'Partner Address';

comment on column public.stock_rule.propagate_warehouse_id is 'Warehouse to Propagate';

comment on column public.stock_rule.create_uid is 'Created by';

comment on column public.stock_rule.write_uid is 'Last Updated by';

comment on column public.stock_rule.group_propagation_option is 'Propagation of Procurement Group';

comment on column public.stock_rule.action is 'Action';

comment on column public.stock_rule.procure_method is 'Supply Method';

comment on column public.stock_rule.auto is 'Automatic Move';

comment on column public.stock_rule.push_domain is 'Push Applicability';

comment on column public.stock_rule.name is 'Name';

comment on column public.stock_rule.active is 'Active';

comment on column public.stock_rule.location_dest_from_rule is 'Destination location origin from rule';

comment on column public.stock_rule.propagate_cancel is 'Cancel Next Move';

comment on column public.stock_rule.propagate_carrier is 'Propagation of carrier';

comment on column public.stock_rule.create_date is 'Created on';

comment on column public.stock_rule.write_date is 'Last Updated on';

comment on column public.stock_rule.warehouse_id is 'Ware house';

create table public.product_template
(
    id                          uuid    not null
        primary key,
    categ_id                    uuid    not null
        references public.product_category
            on delete restrict,
    uom_id                      uuid    not null
        references public.uom_uom
            on delete restrict,
    uom_po_id                   uuid    not null
        references public.uom_uom
            on delete restrict,
    company_id                  uuid
                                        references public.res_company
                                            on delete set null,
    color                       integer,
    create_uid                  uuid
                                        references public.res_users
                                            on delete set null,
    write_uid                   uuid
                                        references public.res_users
                                            on delete set null,
    type                        varchar not null,
    service_tracking            varchar not null,
    default_code                varchar,
    name                        jsonb   not null,
    description                 jsonb,
    description_purchase        jsonb,
    description_sale            jsonb,
    product_properties          jsonb,
    list_price                  numeric,
    volume                      numeric,
    weight                      numeric,
    sale_ok                     boolean,
    purchase_ok                 boolean,
    active                      boolean,
    can_image_1024_be_zoomed    boolean,
    has_configurable_attributes boolean,
    is_favorite                 boolean,
    create_date                 timestamp,
    write_date                  timestamp,
    sale_delay                  integer,
    tracking                    varchar not null,
    responsible_id              jsonb,
    property_stock_production   jsonb,
    property_stock_inventory    jsonb,
    description_picking         jsonb,
    description_pickingout      jsonb,
    description_pickingin       jsonb,
    is_storable                 boolean,
    expiration_time             integer,
    use_time                    integer,
    removal_time                integer,
    alert_time                  integer,
    use_expiration_date         boolean
);

comment on table public.product_template is 'Product';

comment on column public.product_template.categ_id is 'Product Category';

comment on column public.product_template.uom_id is 'Unit of Measure';

comment on column public.product_template.uom_po_id is 'Purchase Unit';

comment on column public.product_template.company_id is 'Company';

comment on column public.product_template.color is 'Color Index';

comment on column public.product_template.create_uid is 'Created by';

comment on column public.product_template.write_uid is 'Last Updated by';

comment on column public.product_template.type is 'Product Type';

comment on column public.product_template.service_tracking is 'Create on Order';

comment on column public.product_template.default_code is 'Internal Reference';

comment on column public.product_template.name is 'Name';

comment on column public.product_template.description is 'Description';

comment on column public.product_template.description_purchase is 'Purchase Description';

comment on column public.product_template.description_sale is 'Sales Description';

comment on column public.product_template.product_properties is 'Properties';

comment on column public.product_template.list_price is 'Sales Price';

comment on column public.product_template.volume is 'Volume';

comment on column public.product_template.weight is 'Weight';

comment on column public.product_template.sale_ok is 'Sales';

comment on column public.product_template.purchase_ok is 'Purchase';

comment on column public.product_template.active is 'Active';

comment on column public.product_template.can_image_1024_be_zoomed is 'Can Image 1024 be zoomed';

comment on column public.product_template.has_configurable_attributes is 'Is a configurable product';

comment on column public.product_template.is_favorite is 'Favorite';

comment on column public.product_template.create_date is 'Created on';

comment on column public.product_template.write_date is 'Last Updated on';

comment on column public.product_template.sale_delay is 'Customer Lead Time';

comment on column public.product_template.tracking is 'Tracking';

comment on column public.product_template.responsible_id is 'Responsible';

comment on column public.product_template.property_stock_production is 'Production Location';

comment on column public.product_template.property_stock_inventory is 'Inventory Location';

comment on column public.product_template.description_picking is 'Description on Picking';

comment on column public.product_template.description_pickingout is 'Description on Delivery Orders';

comment on column public.product_template.description_pickingin is 'Description on Receptions';

comment on column public.product_template.is_storable is 'Track Inventory';

comment on column public.product_template.expiration_time is 'Expiration Date';

comment on column public.product_template.use_time is 'Best Before Date';

comment on column public.product_template.removal_time is 'Removal Date';

comment on column public.product_template.alert_time is 'Alert Date';

comment on column public.product_template.use_expiration_date is 'Use Expiration Date';


create table public.product_product
(
    id                               uuid not null
        primary key,
    product_tmpl_id                  uuid not null
        references public.product_template
            on delete cascade,
    create_uid                       uuid
                                          references public.res_users
                                              on delete set null,
    write_uid                        uuid
                                          references public.res_users
                                              on delete set null,
    default_code                     varchar,
    barcode                          varchar,
    combination_indices              varchar,
    standard_price                   jsonb,
    volume                           numeric,
    weight                           numeric,
    active                           boolean,
    can_image_variant_1024_be_zoomed boolean,
    write_date                       timestamp,
    create_date                      timestamp,
    lot_properties_definition        jsonb
);

comment on table public.product_product is 'Product Variant';

comment on column public.product_product.product_tmpl_id is 'Product Template';

comment on column public.product_product.create_uid is 'Created by';

comment on column public.product_product.write_uid is 'Last Updated by';

comment on column public.product_product.default_code is 'Internal Reference';

comment on column public.product_product.barcode is 'Barcode';

comment on column public.product_product.combination_indices is 'Combination Indices';

comment on column public.product_product.standard_price is 'Cost';

comment on column public.product_product.volume is 'Volume';

comment on column public.product_product.weight is 'Weight';

comment on column public.product_product.active is 'Active';

comment on column public.product_product.can_image_variant_1024_be_zoomed is 'Can Variant Image 1024 be zoomed';

comment on column public.product_product.write_date is 'Write Date';

comment on column public.product_product.create_date is 'Created on';

comment on column public.product_product.lot_properties_definition is 'Lot Properties';

create table public.stock_lot
(
    id                      uuid    not null
        primary key,
    product_id              uuid    not null
        references public.product_product
            on delete restrict,
    product_uom_id          uuid
                                    references public.uom_uom
                                        on delete set null,
    company_id              uuid
                                    references public.res_company
                                        on delete set null,
    location_id             uuid
                                    references public.stock_location
                                        on delete set null,
    create_uid              uuid
                                    references public.res_users
                                        on delete set null,
    write_uid               uuid
                                    references public.res_users
                                        on delete set null,
    name                    varchar not null,
    ref                     varchar,
    lot_properties          jsonb,
    note                    text,
    create_date             timestamp,
    write_date              timestamp,
    product_expiry_reminded boolean,
    expiration_date         timestamp,
    use_date                timestamp,
    removal_date            timestamp,
    alert_date              timestamp
);

comment on table public.stock_lot is 'Lot/Serial';

comment on column public.stock_lot.product_id is 'Product';

comment on column public.stock_lot.product_uom_id is 'Unit of Measure';

comment on column public.stock_lot.company_id is 'Company';

comment on column public.stock_lot.location_id is 'Location';

comment on column public.stock_lot.create_uid is 'Created by';

comment on column public.stock_lot.write_uid is 'Last Updated by';

comment on column public.stock_lot.name is 'Lot/Serial Number';

comment on column public.stock_lot.ref is 'Internal Reference';

comment on column public.stock_lot.lot_properties is 'Properties';

comment on column public.stock_lot.note is 'Description';

comment on column public.stock_lot.create_date is 'Created on';

comment on column public.stock_lot.write_date is 'Last Updated on';

comment on column public.stock_lot.product_expiry_reminded is 'Expiry has been reminded';

comment on column public.stock_lot.expiration_date is 'Expiration Date';

comment on column public.stock_lot.use_date is 'Best before Date';

comment on column public.stock_lot.removal_date is 'Removal Date';

comment on column public.stock_lot.alert_date is 'Alert Date';


create table public.stock_warehouse_orderpoint
(
    id                  uuid    not null
        primary key,
    warehouse_id        uuid    not null
        references public.stock_warehouse
            on delete cascade,
    location_id         uuid    not null
        references public.stock_location
            on delete cascade,
    product_id          uuid    not null
        references public.product_product
            on delete cascade,
    product_category_id uuid
                                references public.product_category
                                    on delete set null,
    group_id            uuid
                                references public.procurement_group
                                    on delete set null,
    company_id          uuid    not null
        references public.res_company
            on delete restrict,
    route_id            uuid
                                references public.stock_route
                                    on delete set null,
    create_uid          uuid
                                references public.res_users
                                    on delete set null,
    write_uid           uuid
                                references public.res_users
                                    on delete set null,
    name                varchar not null,
    trigger             varchar not null,
    snoozed_until       date,
    product_min_qty     numeric not null,
    product_max_qty     numeric not null,
    qty_multiple        numeric not null
        constraint stock_warehouse_orderpoint_qty_multiple_check
            check (qty_multiple >= (0)::numeric),
    qty_to_order_manual numeric,
    active              boolean,
    create_date         timestamp,
    write_date          timestamp,
    constraint stock_warehouse_orderpoint_product_location_check
        unique (product_id, location_id, company_id)
);

comment on table public.stock_warehouse_orderpoint is 'Minimum Inventory Rule';

comment on column public.stock_warehouse_orderpoint.warehouse_id is 'Warehouse';

comment on column public.stock_warehouse_orderpoint.location_id is 'Location';

comment on column public.stock_warehouse_orderpoint.product_id is 'Product';

comment on column public.stock_warehouse_orderpoint.product_category_id is 'Product Category';

comment on column public.stock_warehouse_orderpoint.group_id is 'Procurement Group';

comment on column public.stock_warehouse_orderpoint.company_id is 'Company';

comment on column public.stock_warehouse_orderpoint.route_id is 'Route';

comment on column public.stock_warehouse_orderpoint.create_uid is 'Created by';

comment on column public.stock_warehouse_orderpoint.write_uid is 'Last Updated by';

comment on column public.stock_warehouse_orderpoint.name is 'Name';

comment on column public.stock_warehouse_orderpoint.trigger is 'Trigger';

comment on column public.stock_warehouse_orderpoint.snoozed_until is 'Snoozed';

comment on column public.stock_warehouse_orderpoint.product_min_qty is 'Min Quantity';

comment on column public.stock_warehouse_orderpoint.product_max_qty is 'Max Quantity';

comment on column public.stock_warehouse_orderpoint.qty_multiple is 'Multiple Quantity';

comment on constraint stock_warehouse_orderpoint_qty_multiple_check on public.stock_warehouse_orderpoint is 'CHECK( qty_multiple >= 0 )';

comment on column public.stock_warehouse_orderpoint.qty_to_order_manual is 'To Order Manual';

comment on column public.stock_warehouse_orderpoint.active is 'Active';

comment on column public.stock_warehouse_orderpoint.create_date is 'Created on';

comment on column public.stock_warehouse_orderpoint.write_date is 'Last Updated on';

comment on constraint stock_warehouse_orderpoint_product_location_check on public.stock_warehouse_orderpoint is 'unique (product_id, location_id, company_id)';



create table public.stock_quant
(
    id                      uuid      not null
        primary key,
    product_id              uuid      not null
        references public.product_product
            on delete restrict,
    company_id              uuid
                                      references public.res_company
                                          on delete set null,
    location_id             uuid      not null
        references public.stock_location
            on delete restrict,
    storage_category_id     uuid,
    lot_id                  uuid
        references public.stock_lot
            on delete restrict,
    package_id              uuid,
    owner_id                uuid,
    user_id                 uuid
                                      references public.res_users
                                          on delete set null,
    create_uid              uuid
                                      references public.res_users
                                          on delete set null,
    write_uid               uuid
                                      references public.res_users
                                          on delete set null,
    inventory_date          date,
    quantity                numeric,
    reserved_quantity       numeric   not null,
    inventory_quantity      numeric,
    inventory_diff_quantity numeric,
    inventory_quantity_set  boolean,
    in_date                 timestamp not null,
    create_date             timestamp,
    write_date              timestamp,
    expiration_date         timestamp,
    removal_date            timestamp
);

comment on table public.stock_quant is 'Quants';

comment on column public.stock_quant.product_id is 'Product';

comment on column public.stock_quant.company_id is 'Company';

comment on column public.stock_quant.location_id is 'Location';

comment on column public.stock_quant.storage_category_id is 'Storage Category';

comment on column public.stock_quant.lot_id is 'Lot/Serial Number';

comment on column public.stock_quant.package_id is 'Package';

comment on column public.stock_quant.owner_id is 'Owner';

comment on column public.stock_quant.user_id is 'Assigned To';

comment on column public.stock_quant.create_uid is 'Created by';

comment on column public.stock_quant.write_uid is 'Last Updated by';

comment on column public.stock_quant.inventory_date is 'Scheduled Date';

comment on column public.stock_quant.quantity is 'Quantity';

comment on column public.stock_quant.reserved_quantity is 'Reserved Quantity';

comment on column public.stock_quant.inventory_quantity is 'Counted Quantity';

comment on column public.stock_quant.inventory_diff_quantity is 'Difference';

comment on column public.stock_quant.inventory_quantity_set is 'Inventory Quantity Set';

comment on column public.stock_quant.in_date is 'Incoming Date';

comment on column public.stock_quant.create_date is 'Created on';

comment on column public.stock_quant.write_date is 'Last Updated on';

comment on column public.stock_quant.expiration_date is 'Expiration Date';

comment on column public.stock_quant.removal_date is 'Removal Date';



create table public.stock_scrap
(
    id                uuid    not null
        primary key,
    company_id        uuid    not null,
    product_id        uuid    not null
        references public.product_product
            on delete restrict,
    product_uom_id    uuid    not null,
    lot_id            uuid
                              references public.stock_lot
                                  on delete set null,
    package_id        uuid,
    owner_id          uuid,
    picking_id        uuid,
    location_id       uuid    not null
        references public.stock_location
            on delete restrict,
    scrap_location_id uuid    not null
        references public.stock_location
            on delete restrict,
    create_uid        uuid,
    write_uid         uuid,
    name              varchar not null,
    origin            varchar,
    state             varchar,
    scrap_qty         numeric not null,
    should_replenish  boolean,
    date_done         timestamp,
    create_date       timestamp,
    write_date        timestamp
);

comment on table public.stock_scrap is 'Scrap';

comment on column public.stock_scrap.company_id is 'Company';

comment on column public.stock_scrap.product_id is 'Product';

comment on column public.stock_scrap.product_uom_id is 'Unit of Measure';

comment on column public.stock_scrap.lot_id is 'Lot/Serial';

comment on column public.stock_scrap.package_id is 'Package';

comment on column public.stock_scrap.owner_id is 'Owner';

comment on column public.stock_scrap.picking_id is 'Picking';

comment on column public.stock_scrap.location_id is 'Source Location';

comment on column public.stock_scrap.scrap_location_id is 'Scrap Location';

comment on column public.stock_scrap.create_uid is 'Created by';

comment on column public.stock_scrap.write_uid is 'Last Updated by';

comment on column public.stock_scrap.name is 'Reference';

comment on column public.stock_scrap.origin is 'Source Document';

comment on column public.stock_scrap.state is 'Status';

comment on column public.stock_scrap.scrap_qty is 'Quantity';

comment on column public.stock_scrap.should_replenish is 'Replenish Quantities';

comment on column public.stock_scrap.date_done is 'Date';

comment on column public.stock_scrap.create_date is 'Created on';

comment on column public.stock_scrap.write_date is 'Last Updated on';

create table public.stock_move
(
    id                      uuid      not null
        primary key,
    company_id              uuid      not null
        references public.res_company
            on delete restrict,
    product_id              uuid      not null
        references public.product_product
            on delete restrict,
    product_uom             integer   not null,
    location_id             uuid      not null
        references public.stock_location
            on delete restrict,
    location_dest_id        uuid      not null
        references public.stock_location
            on delete restrict,
    location_final_id       uuid
                                      references public.stock_location
                                          on delete set null,
    partner_id              uuid,
    picking_id              uuid,
    scrap_id                uuid,
    group_id                uuid,
    rule_id                 uuid,
    picking_type_id         uuid,
    origin_returned_move_id uuid,
    restrict_partner_id     uuid,
    package_level_id        uuid,
    next_serial_count       integer,
    orderpoint_id           uuid,
    product_packaging_id    uuid,
    create_uid              uuid
                                      references public.res_users
                                          on delete set null,
    write_uid               uuid
                                      references public.res_users
                                          on delete set null,
    name                    varchar   not null,
    priority                varchar,
    state                   varchar,
    origin                  varchar,
    procure_method          varchar   not null,
    reference               varchar,
    next_serial             varchar,
    reservation_date        date,
    description_picking     text,
    product_qty             numeric,
    product_uom_qty         numeric   not null,
    quantity                numeric,
    picked                  boolean,
    scrapped                boolean,
    propagate_cancel        boolean,
    is_inventory            boolean,
    additional              boolean,
    date                    timestamp not null,
    date_deadline           timestamp,
    delay_alert_date        timestamp,
    create_date             timestamp,
    write_date              timestamp,
    price_unit              double precision,
    warehouse_id            uuid
);

comment on column public.stock_move.warehouse_id is 'Ware house';

create table public.stock_move_line
(
    id                   uuid      not null
        primary key,
    picking_id           uuid,
    move_id              uuid,
    company_id           uuid      not null,
    product_id           uuid
        references public.product_product
            on delete cascade,
    product_uom_id       uuid      not null,
    package_id           uuid,
    package_level_id     uuid,
    lot_id               uuid
                                   references public.stock_lot
                                       on delete set null,
    result_package_id    uuid,
    owner_id             uuid,
    location_id          uuid      not null
        references public.stock_location
            on delete restrict,
    location_dest_id     uuid      not null
        references public.stock_location
            on delete restrict,
    create_uid           uuid,
    write_uid            uuid,
    lot_name             varchar,
    state                varchar,
    reference            varchar,
    description_picking  text,
    quantity             numeric,
    quantity_product_uom numeric,
    picked               boolean,
    date                 timestamp not null,
    create_date          timestamp,
    write_date           timestamp,
    expiration_date      timestamp
);

comment on table public.stock_move_line is 'Product Moves (Stock Move Line)';

comment on column public.stock_move_line.picking_id is 'Transfer';

comment on column public.stock_move_line.move_id is 'Stock Operation';

comment on column public.stock_move_line.company_id is 'Company';

comment on column public.stock_move_line.product_id is 'Product';

comment on column public.stock_move_line.product_uom_id is 'Unit of Measure';

comment on column public.stock_move_line.package_id is 'Source Package';

comment on column public.stock_move_line.package_level_id is 'Package Level';

comment on column public.stock_move_line.lot_id is 'Lot/Serial Number';

comment on column public.stock_move_line.result_package_id is 'Destination Package';

comment on column public.stock_move_line.owner_id is 'From Owner';

comment on column public.stock_move_line.location_id is 'From';

comment on column public.stock_move_line.location_dest_id is 'To';

comment on column public.stock_move_line.create_uid is 'Created by';

comment on column public.stock_move_line.write_uid is 'Last Updated by';

comment on column public.stock_move_line.lot_name is 'Lot/Serial Number Name';

comment on column public.stock_move_line.state is 'Status';

comment on column public.stock_move_line.reference is 'Reference';

comment on column public.stock_move_line.description_picking is 'Description picking';

comment on column public.stock_move_line.quantity is 'Quantity';

comment on column public.stock_move_line.quantity_product_uom is 'Quantity in Product UoM';

comment on column public.stock_move_line.picked is 'Picked';

comment on column public.stock_move_line.date is 'Date';

comment on column public.stock_move_line.create_date is 'Created on';

comment on column public.stock_move_line.write_date is 'Last Updated on';



create table public.stock_quant_package
(
    id              uuid    not null
        primary key,
    package_type_id uuid
                            references public.stock_package_type
                                on delete set null,
    location_id     uuid
                            references public.stock_location
                                on delete set null,
    company_id      uuid
                            references public.res_company
                                on delete set null,
    create_uid      uuid
                            references public.res_users
                                on delete set null,
    write_uid       uuid
                            references public.res_users
                                on delete set null,
    name            varchar not null,
    package_use     varchar not null,
    pack_date       date,
    create_date     timestamp,
    write_date      timestamp,
    shipping_weight double precision
);

comment on table public.stock_quant_package is 'Packages';

comment on column public.stock_quant_package.package_type_id is 'Package Type';

comment on column public.stock_quant_package.location_id is 'Location';

comment on column public.stock_quant_package.company_id is 'Company';

comment on column public.stock_quant_package.create_uid is 'Created by';

comment on column public.stock_quant_package.write_uid is 'Last Updated by';

comment on column public.stock_quant_package.name is 'Package Reference';

comment on column public.stock_quant_package.package_use is 'Package Use';

comment on column public.stock_quant_package.pack_date is 'Pack Date';

comment on column public.stock_quant_package.create_date is 'Created on';

comment on column public.stock_quant_package.write_date is 'Last Updated on';

comment on column public.stock_quant_package.shipping_weight is 'Shipping Weight';



create table public.stock_storage_category
(
    id                uuid    not null
        primary key,
    company_id        uuid
                              references public.res_company
                                  on delete set null,
    create_uid        uuid
                              references public.res_users
                                  on delete set null,
    write_uid         uuid
                              references public.res_users
                                  on delete set null,
    name              varchar not null,
    allow_new_product varchar not null,
    max_weight        numeric
        constraint stock_storage_category_positive_max_weight
            check (max_weight >= (0)::numeric),
    create_date       timestamp,
    write_date        timestamp
);

comment on table public.stock_storage_category is 'Storage Category';

comment on column public.stock_storage_category.company_id is 'Company';

comment on column public.stock_storage_category.create_uid is 'Created by';

comment on column public.stock_storage_category.write_uid is 'Last Updated by';

comment on column public.stock_storage_category.name is 'Storage Category';

comment on column public.stock_storage_category.allow_new_product is 'Allow New Product';

comment on column public.stock_storage_category.max_weight is 'Max Weight';

comment on constraint stock_storage_category_positive_max_weight on public.stock_storage_category is 'CHECK(max_weight >= 0)';

comment on column public.stock_storage_category.create_date is 'Created on';

comment on column public.stock_storage_category.write_date is 'Last Updated on';

