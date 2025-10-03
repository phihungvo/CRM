drop table if exists ir_ui_view;
create table ir_ui_view
(
    id             uuid,
    priority       integer not null,
    inherit_id     uuid,
    create_uid     uuid,
    write_uid      uuid,
    name           varchar not null,
    model          varchar,
    key            varchar,
    type           varchar,
    arch_fs        varchar,
    mode           varchar not null,
    arch_db        jsonb,
    arch_prev      text,
    arch_updated   boolean,
    active         boolean,
    create_date    timestamp,
    write_date     timestamp,
    customize_show boolean
);

comment on table ir_ui_view is 'View';

comment on column ir_ui_view.priority is 'Sequence';

comment on column ir_ui_view.inherit_id is 'Inherited View';

comment on column ir_ui_view.create_uid is 'Created by';

comment on column ir_ui_view.write_uid is 'Last Updated by';

comment on column ir_ui_view.name is 'View Name';

comment on column ir_ui_view.model is 'Model';

comment on column ir_ui_view.key is 'Key';

comment on column ir_ui_view.type is 'View Type';

comment on column ir_ui_view.arch_fs is 'Arch Filename';

comment on column ir_ui_view.mode is 'View inheritance mode';

comment on column ir_ui_view.arch_db is 'Arch Blob';

comment on column ir_ui_view.arch_prev is 'Previous View Architecture';

comment on column ir_ui_view.arch_updated is 'Modified Architecture';

comment on column ir_ui_view.active is 'Active';

comment on column ir_ui_view.create_date is 'Created on';

comment on column ir_ui_view.write_date is 'Last Updated on';

comment on column ir_ui_view.customize_show is 'Show As Optional Inherit';

alter table ir_ui_view
    add primary key (id);

alter table ir_ui_view
    add foreign key (inherit_id) references ir_ui_view
        on delete restrict;

alter table ir_ui_view
    add constraint ir_ui_view_inheritance_mode
        check (((mode)::text <> 'extension'::text) OR (inherit_id IS NOT NULL));

comment on constraint ir_ui_view_inheritance_mode on ir_ui_view is 'CHECK (mode != ''extension'' OR inherit_id IS NOT NULL)';

alter table ir_ui_view
    add constraint ir_ui_view_qweb_required_key
        check (((type)::text <> 'qweb'::text) OR (key IS NOT NULL));

comment on constraint ir_ui_view_qweb_required_key on ir_ui_view is 'CHECK (type != ''qweb'' OR key IS NOT NULL)';



drop table if exists res_users;
create table res_users
(
    id                uuid
        primary key,
    company_id        uuid    not null,
    partner_id        uuid    not null,
    active            boolean default true,
    create_date       timestamp,
    login             varchar not null
        unique,
    password          varchar,
    action_id         uuid,
    create_uid        uuid
                              references res_users
                                  on delete set null,
    write_uid         uuid
                              references res_users
                                  on delete set null,
    signature         text,
    share             boolean,
    write_date        timestamp,
    totp_secret       varchar,
    tour_enabled      boolean,
    notification_type varchar not null,
    odoobot_state     varchar,
    odoobot_failed    boolean,
    constraint res_users_notification_type
        check (((notification_type)::text = 'email'::text) OR (NOT share))
);

comment on column res_users.action_id is 'Home Action';

comment on column res_users.create_uid is 'Created by';

comment on column res_users.write_uid is 'Last Updated by';

comment on column res_users.signature is 'Email Signature';

comment on column res_users.share is 'Share User';

comment on column res_users.write_date is 'Last Updated on';

comment on column res_users.tour_enabled is 'Onboarding';

comment on column res_users.notification_type is 'Notification';

comment on column res_users.odoobot_state is 'OdooBot Status';

comment on column res_users.odoobot_failed is 'Odoobot Failed';

comment on constraint res_users_notification_type on res_users is 'CHECK (notification_type = ''email'' OR NOT share)';





drop table if exists res_currency;
create table res_currency
(
    id                     uuid,
    name                   varchar not null,
    symbol                 varchar not null,
    iso_numeric            integer,
    decimal_places         integer,
    create_uid             uuid,
    write_uid              uuid,
    full_name              varchar,
    position               varchar,
    currency_unit_label    jsonb,
    currency_subunit_label jsonb,
    rounding               numeric,
    active                 boolean,
    create_date            timestamp,
    write_date             timestamp
);

comment on column res_currency.iso_numeric is 'Currency numeric code.';

comment on column res_currency.decimal_places is 'Decimal Places';

comment on column res_currency.create_uid is 'Created by';

comment on column res_currency.write_uid is 'Last Updated by';

comment on column res_currency.full_name is 'Name';

comment on column res_currency.position is 'Symbol Position';

comment on column res_currency.currency_unit_label is 'Currency Unit';

comment on column res_currency.currency_subunit_label is 'Currency Subunit';

comment on column res_currency.rounding is 'Rounding Factor';

comment on column res_currency.active is 'Active';

comment on column res_currency.create_date is 'Created on';

comment on column res_currency.write_date is 'Last Updated on';

alter table res_currency
    add primary key (id);

alter table res_currency
    add constraint res_currency_unique_name
        unique (name);

comment on constraint res_currency_unique_name on res_currency is 'unique (name)';

-- alter table res_currency
--     add foreign key (create_uid) references res_users
--         on delete set null;

-- alter table res_currency
--     add foreign key (write_uid) references res_users
--         on delete set null;

alter table res_currency
    add constraint res_currency_rounding_gt_zero
        check (rounding > (0)::numeric);

comment on constraint res_currency_rounding_gt_zero on res_currency is 'CHECK (rounding>0)';



drop table if exists res_country;
create table res_country
(
    id              uuid,
    address_view_id uuid,
    currency_id     uuid,
    phone_code      integer,
    create_uid      uuid,
    write_uid       uuid,
    code            varchar(2) not null,
    name_position   varchar,
    name            jsonb      not null,
    vat_label       jsonb,
    address_format  text,
    state_required  boolean,
    zip_required    boolean,
    create_date     timestamp,
    write_date      timestamp
);

comment on table res_country is 'Country';

comment on column res_country.address_view_id is 'Input View';

comment on column res_country.currency_id is 'Currency';

comment on column res_country.phone_code is 'Country Calling Code';

comment on column res_country.create_uid is 'Created by';

comment on column res_country.write_uid is 'Last Updated by';

comment on column res_country.code is 'Country Code';

comment on column res_country.name_position is 'Customer Name Position';

comment on column res_country.name is 'Country Name';

comment on column res_country.vat_label is 'Vat Label';

comment on column res_country.address_format is 'Layout in Reports';

comment on column res_country.state_required is 'State Required';

comment on column res_country.zip_required is 'Zip Required';

comment on column res_country.create_date is 'Created on';

comment on column res_country.write_date is 'Last Updated on';

alter table res_country
    add primary key (id);

alter table res_country
    add constraint res_country_name_uniq
        unique (name);

comment on constraint res_country_name_uniq on res_country is 'unique (name)';

alter table res_country
    add constraint res_country_code_uniq
        unique (code);

comment on constraint res_country_code_uniq on res_country is 'unique (code)';

alter table res_country
    add foreign key (address_view_id) references ir_ui_view
        on delete set null;

alter table res_country
    add foreign key (currency_id) references res_currency
        on delete set null;

-- alter table res_country
--     add foreign key (create_uid) references res_users
--         on delete set null;

-- alter table res_country
--     add foreign key (write_uid) references res_users
--         on delete set null;



drop table if exists res_country_state;
create table res_country_state
(
    id          uuid,
    country_id  uuid not null,
    create_uid  uuid,
    write_uid   uuid,
    name        varchar not null,
    code        varchar not null,
    create_date timestamp,
    write_date  timestamp
);

comment on table res_country_state is 'Country state';

comment on column res_country_state.country_id is 'Country';

comment on column res_country_state.create_uid is 'Created by';

comment on column res_country_state.write_uid is 'Last Updated by';

comment on column res_country_state.name is 'State Name';

comment on column res_country_state.code is 'State Code';

comment on column res_country_state.create_date is 'Created on';

comment on column res_country_state.write_date is 'Last Updated on';

alter table res_country_state
    add primary key (id);

alter table res_country_state
    add constraint res_country_state_name_code_uniq
        unique (country_id, code);

comment on constraint res_country_state_name_code_uniq on res_country_state is 'unique(country_id, code)';

alter table res_country_state
    add foreign key (country_id) references res_country
        on delete restrict;

-- alter table res_country_state
--     add foreign key (create_uid) references res_users
--         on delete set null;

-- alter table res_country_state
--     add foreign key (write_uid) references res_users
--         on delete set null;





drop table if exists res_partner_title;
create table res_partner_title
(
    id          uuid,
    create_uid  uuid,
    write_uid   uuid,
    name        jsonb not null,
    shortcut    jsonb,
    create_date timestamp,
    write_date  timestamp
);

comment on table res_partner_title is 'Partner Title';

comment on column res_partner_title.create_uid is 'Created by';

comment on column res_partner_title.write_uid is 'Last Updated by';

comment on column res_partner_title.name is 'Title';

comment on column res_partner_title.shortcut is 'Abbreviation';

comment on column res_partner_title.create_date is 'Created on';

comment on column res_partner_title.write_date is 'Last Updated on';

alter table res_partner_title
    add primary key (id);

-- alter table res_partner_title
--     add foreign key (create_uid) references res_users
--         on delete set null;

-- alter table res_partner_title
--     add foreign key (write_uid) references res_users
--         on delete set null;



drop table if exists res_partner_industry;
create table res_partner_industry
(
    id          uuid,
    create_uid  uuid,
    write_uid   uuid,
    name        jsonb,
    full_name   jsonb,
    active      boolean,
    create_date timestamp,
    write_date  timestamp
);

comment on table res_partner_industry is 'Industry';

comment on column res_partner_industry.create_uid is 'Created by';

comment on column res_partner_industry.write_uid is 'Last Updated by';

comment on column res_partner_industry.name is 'Name';

comment on column res_partner_industry.full_name is 'Full Name';

comment on column res_partner_industry.active is 'Active';

comment on column res_partner_industry.create_date is 'Created on';

comment on column res_partner_industry.write_date is 'Last Updated on';

alter table res_partner_industry
    add primary key (id);

alter table res_partner_industry
    add foreign key (create_uid) references res_users
        on delete set null;

alter table res_partner_industry
    add foreign key (write_uid) references res_users
        on delete set null;





drop table if exists res_partner;
create table res_partner
(
	id uuid
		primary key,
	company_id uuid,
	create_date timestamp,
	name varchar,
	title integer,
	parent_id uuid
		references res_partner
			on delete set null,
	user_id uuid
		references res_users
			on delete set null,
	state_id uuid
		references res_country_state
			on delete restrict,
	country_id uuid
		references res_country
			on delete restrict,
	industry_id uuid
		references res_partner_industry
			on delete set null,
	color integer,
	commercial_partner_id uuid
		references res_partner
			on delete set null,
	create_uid uuid
		references res_users
			on delete set null,
	write_uid uuid
		references res_users
			on delete set null,
	complete_name varchar,
	ref varchar,
	lang varchar,
	tz varchar,
	vat varchar,
	company_registry varchar,
	website varchar,
	function varchar,
	type varchar,
	street varchar,
	street2 varchar,
	zip varchar,
	city varchar,
	email varchar,
	phone varchar,
	mobile varchar,
	commercial_company_name varchar,
	company_name varchar,
	barcode jsonb,
	comment text,
	partner_latitude numeric,
	partner_longitude numeric,
	active boolean,
	employee boolean,
	is_company boolean,
	partner_share boolean,
	write_date timestamp,
	message_bounce integer,
	email_normalized varchar,
	signup_type varchar,
	specific_property_product_pricelist jsonb,
	partner_gid uuid,
	additional_info varchar,
	phone_sanitized varchar,
	invoice_template_pdf_report_id uuid,
	supplier_rank integer,
	customer_rank integer,
	invoice_warn varchar,
	autopost_bills varchar not null,
	credit_limit jsonb,
	property_account_payable_id jsonb,
	property_account_receivable_id jsonb,
	property_account_position_id jsonb,
	property_payment_term_id jsonb,
	property_supplier_payment_term_id jsonb,
	trust jsonb,
	ignore_abnormal_invoice_date jsonb,
	ignore_abnormal_invoice_amount jsonb,
	invoice_sending_method jsonb,
	invoice_edi_format_store jsonb,
	property_outbound_payment_method_line_id jsonb,
	property_inbound_payment_method_line_id jsonb,
	invoice_warn_msg text,
	debit_limit numeric,
	peppol_endpoint varchar,
	peppol_eas varchar,
	buyer_id uuid
		references res_users
			on delete set null,
	purchase_warn varchar,
	property_purchase_currency_id jsonb,
	receipt_reminder_email jsonb,
	reminder_date_before_receipt jsonb,
	purchase_warn_msg text,
	constraint res_partner_check_name
		check ((((type)::text = 'contact'::text) AND (name IS NOT NULL)) OR ((type)::text <> 'contact'::text))
);

comment on column res_partner.title is 'Title';

comment on column res_partner.parent_id is 'Related Company';

comment on column res_partner.user_id is 'Salesperson';

comment on column res_partner.state_id is 'State';

comment on column res_partner.country_id is 'Country';

comment on column res_partner.industry_id is 'Industry';

comment on column res_partner.color is 'Color Index';

comment on column res_partner.commercial_partner_id is 'Commercial Entity';

comment on column res_partner.create_uid is 'Created by';

comment on column res_partner.write_uid is 'Last Updated by';

comment on column res_partner.complete_name is 'Complete Name';

comment on column res_partner.ref is 'Reference';

comment on column res_partner.lang is 'Language';

comment on column res_partner.tz is 'Timezone';

comment on column res_partner.vat is 'Tax ID';

comment on column res_partner.company_registry is 'Company ID';

comment on column res_partner.website is 'Website Link';

comment on column res_partner.function is 'Job Position';

comment on column res_partner.type is 'Address Type';

comment on column res_partner.street is 'Street';

comment on column res_partner.street2 is 'Street2';

comment on column res_partner.zip is 'Zip';

comment on column res_partner.city is 'City';

comment on column res_partner.email is 'Email';

comment on column res_partner.phone is 'Phone';

comment on column res_partner.mobile is 'Mobile';

comment on column res_partner.commercial_company_name is 'Company Name Entity';

comment on column res_partner.company_name is 'Company Name';

comment on column res_partner.barcode is 'Barcode';

comment on column res_partner.comment is 'Notes';

comment on column res_partner.partner_latitude is 'Geo Latitude';

comment on column res_partner.partner_longitude is 'Geo Longitude';

comment on column res_partner.active is 'Active';

comment on column res_partner.employee is 'Employee';

comment on column res_partner.is_company is 'Is a Company';

comment on column res_partner.partner_share is 'Share Partner';

comment on column res_partner.write_date is 'Last Updated on';

comment on column res_partner.message_bounce is 'Bounce';

comment on column res_partner.email_normalized is 'Normalized Email';

comment on column res_partner.signup_type is 'Signup Token Type';

comment on column res_partner.specific_property_product_pricelist is 'Specific Property Product Pricelist';

comment on column res_partner.partner_gid is 'Company database ID';

comment on column res_partner.additional_info is 'Additional info';

comment on column res_partner.phone_sanitized is 'Sanitized Number';

comment on column res_partner.invoice_template_pdf_report_id is 'Invoice Template Pdf Report';

comment on column res_partner.supplier_rank is 'Supplier Rank';

comment on column res_partner.customer_rank is 'Customer Rank';

comment on column res_partner.invoice_warn is 'Invoice';

comment on column res_partner.autopost_bills is 'Auto-post bills';

comment on column res_partner.credit_limit is 'Credit Limit';

comment on column res_partner.property_account_payable_id is 'Account Payable';

comment on column res_partner.property_account_receivable_id is 'Account Receivable';

comment on column res_partner.property_account_position_id is 'Fiscal Position';

comment on column res_partner.property_payment_term_id is 'Customer Payment Terms';

comment on column res_partner.property_supplier_payment_term_id is 'Vendor Payment Terms';

comment on column res_partner.trust is 'Degree of trust you have in this debtor';

comment on column res_partner.ignore_abnormal_invoice_date is 'Ignore Abnormal Invoice Date';

comment on column res_partner.ignore_abnormal_invoice_amount is 'Ignore Abnormal Invoice Amount';

comment on column res_partner.invoice_sending_method is 'Invoice sending';

comment on column res_partner.invoice_edi_format_store is 'Invoice Edi Format Store';

comment on column res_partner.property_outbound_payment_method_line_id is 'Property Outbound Payment Method Line';

comment on column res_partner.property_inbound_payment_method_line_id is 'Property Inbound Payment Method Line';

comment on column res_partner.invoice_warn_msg is 'Message for Invoice';

comment on column res_partner.debit_limit is 'Payable Limit';

comment on column res_partner.peppol_endpoint is 'Peppol Endpoint';

comment on column res_partner.peppol_eas is 'Peppol e-address (EAS)';

comment on column res_partner.buyer_id is 'Buyer';

comment on column res_partner.purchase_warn is 'Purchase Order Warning';

comment on column res_partner.property_purchase_currency_id is 'Supplier Currency';

comment on column res_partner.receipt_reminder_email is 'Receipt Reminder';

comment on column res_partner.reminder_date_before_receipt is 'Days Before Receipt';

comment on column res_partner.purchase_warn_msg is 'Message for Purchase Order';

comment on constraint res_partner_check_name on res_partner is 'CHECK( (type=''contact'' AND name IS NOT NULL) or (type!=''contact'') )';



drop table if exists report_paperformat;
create table report_paperformat
(
    id                uuid,
    page_height       integer,
    page_width        integer,
    header_spacing    integer,
    dpi               integer not null,
    create_uid        uuid,
    write_uid         uuid,
    name              varchar not null,
    format            varchar,
    orientation       varchar,
    "default"         boolean,
    header_line       boolean,
    disable_shrinking boolean,
    css_margins       boolean,
    create_date       timestamp,
    write_date        timestamp,
    margin_top        double precision,
    margin_bottom     double precision,
    margin_left       double precision,
    margin_right      double precision,
    primary key (id),
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table report_paperformat is 'Paper Format Config';

comment on column report_paperformat.page_height is 'Page height (mm)';

comment on column report_paperformat.page_width is 'Page width (mm)';

comment on column report_paperformat.header_spacing is 'Header spacing';

comment on column report_paperformat.dpi is 'Output DPI';

comment on column report_paperformat.create_uid is 'Created by';

comment on column report_paperformat.write_uid is 'Last Updated by';

comment on column report_paperformat.name is 'Name';

comment on column report_paperformat.format is 'Paper size';

comment on column report_paperformat.orientation is 'Orientation';

comment on column report_paperformat."default" is 'Default paper format?';

comment on column report_paperformat.header_line is 'Display a header line';

comment on column report_paperformat.disable_shrinking is 'Disable smart shrinking';

comment on column report_paperformat.css_margins is 'Use css margins';

comment on column report_paperformat.create_date is 'Created on';

comment on column report_paperformat.write_date is 'Last Updated on';

comment on column report_paperformat.margin_top is 'Top Margin (mm)';

comment on column report_paperformat.margin_bottom is 'Bottom Margin (mm)';

comment on column report_paperformat.margin_left is 'Left Margin (mm)';

comment on column report_paperformat.margin_right is 'Right Margin (mm)';



drop table if exists barcode_nomenclature;
create table barcode_nomenclature
(
    id                  uuid,
    create_uid          uuid,
    write_uid           uuid,
    name                varchar not null,
    upc_ean_conv        varchar not null,
    create_date         timestamp,
    write_date          timestamp,
    gs1_separator_fnc1  varchar,
    is_gs1_nomenclature boolean,
    primary key (id),
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table barcode_nomenclature is 'Barcode Nomenclature';

comment on column barcode_nomenclature.create_uid is 'Created by';

comment on column barcode_nomenclature.write_uid is 'Last Updated by';

comment on column barcode_nomenclature.name is 'Barcode Nomenclature';

comment on column barcode_nomenclature.upc_ean_conv is 'UPC/EAN Conversion';

comment on column barcode_nomenclature.create_date is 'Created on';

comment on column barcode_nomenclature.write_date is 'Last Updated on';

comment on column barcode_nomenclature.gs1_separator_fnc1 is 'FNC1 Separator';

comment on column barcode_nomenclature.is_gs1_nomenclature is 'Is GS1 Nomenclature';


drop table if exists resource_calendar;
create table resource_calendar
(
    id                       uuid,
    company_id               uuid,
    create_uid               uuid,
    write_uid                uuid,
    name                     varchar not null,
    tz                       varchar not null,
    hours_per_day            numeric,
    active                   boolean,
    two_weeks_calendar       boolean,
    flexible_hours           boolean,
    create_date              timestamp,
    write_date               timestamp,
    full_time_required_hours double precision,
    primary key (id),
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table resource_calendar is 'Resource Working Time';

comment on column resource_calendar.company_id is 'Company';

comment on column resource_calendar.create_uid is 'Created by';

comment on column resource_calendar.write_uid is 'Last Updated by';

comment on column resource_calendar.name is 'Name';

comment on column resource_calendar.tz is 'Timezone';

comment on column resource_calendar.hours_per_day is 'Average Hour per Day';

comment on column resource_calendar.active is 'Active';

comment on column resource_calendar.two_weeks_calendar is 'Calendar in 2 weeks mode';

comment on column resource_calendar.flexible_hours is 'Flexible Hours';

comment on column resource_calendar.create_date is 'Created on';

comment on column resource_calendar.write_date is 'Last Updated on';

comment on column resource_calendar.full_time_required_hours is 'Company Full Time';


drop table if exists mail_alias_domain;
create table mail_alias_domain
(
    id             uuid,
    create_uid     uuid,
    write_uid      uuid,
    name           varchar not null,
    bounce_alias   varchar not null,
    catchall_alias varchar not null,
    default_from   varchar,
    create_date    timestamp,
    write_date     timestamp,
    primary key (id),
    constraint mail_alias_domain_bounce_email_uniques
        unique (bounce_alias, name),
    constraint mail_alias_domain_catchall_email_uniques
        unique (catchall_alias, name),
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table mail_alias_domain is 'Email Domain';

comment on column mail_alias_domain.create_uid is 'Created by';

comment on column mail_alias_domain.write_uid is 'Last Updated by';

comment on column mail_alias_domain.name is 'Name';

comment on column mail_alias_domain.bounce_alias is 'Bounce Alias';

comment on column mail_alias_domain.catchall_alias is 'Catchall Alias';

comment on column mail_alias_domain.default_from is 'Default From Alias';

comment on column mail_alias_domain.create_date is 'Created on';

comment on column mail_alias_domain.write_date is 'Last Updated on';

comment on constraint mail_alias_domain_bounce_email_uniques on mail_alias_domain is 'UNIQUE(bounce_alias, name)';

comment on constraint mail_alias_domain_catchall_email_uniques on mail_alias_domain is 'UNIQUE(catchall_alias, name)';




drop table if exists account_account;
create table account_account
(
    id           uuid,
    currency_id  uuid,
    create_uid   uuid,
    write_uid    uuid,
    account_type varchar not null,
    name         jsonb   not null,
    code_store   jsonb,
    note         text,
    deprecated   boolean,
    reconcile    boolean,
    non_trade    boolean,
    create_date  timestamp,
    write_date   timestamp,
    primary key (id),
    foreign key (currency_id) references res_currency
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_account is 'Account';

comment on column account_account.currency_id is 'Account Currency';

comment on column account_account.create_uid is 'Created by';

comment on column account_account.write_uid is 'Last Updated by';

comment on column account_account.account_type is 'Type';

comment on column account_account.name is 'Account Name';

comment on column account_account.code_store is 'Code Store';

comment on column account_account.note is 'Internal Notes';

comment on column account_account.deprecated is 'Deprecated';

comment on column account_account.reconcile is 'Allow Reconciliation';

comment on column account_account.non_trade is 'Non Trade';

comment on column account_account.create_date is 'Created on';

comment on column account_account.write_date is 'Last Updated on';


drop table if exists account_tax_group;
create table account_tax_group
(
    id                             uuid,
    company_id                     uuid not null,
    tax_payable_account_id         uuid,
    tax_receivable_account_id      uuid,
    advance_tax_payment_account_id uuid,
    country_id                     uuid,
    create_uid                     uuid,
    write_uid                      uuid,
    pos_receipt_label              varchar,
    name                           jsonb   not null,
    preceding_subtotal             jsonb,
    create_date                    timestamp,
    write_date                     timestamp,
    primary key (id),
--     foreign key (company_id) references res_company
--         on delete restrict,
    foreign key (tax_payable_account_id) references account_account
        on delete set null,
    foreign key (tax_receivable_account_id) references account_account
        on delete set null,
    foreign key (advance_tax_payment_account_id) references account_account
        on delete set null,
    foreign key (country_id) references res_country
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_tax_group is 'Tax Group';

comment on column account_tax_group.company_id is 'Company';

comment on column account_tax_group.tax_payable_account_id is 'Tax Payable Account';

comment on column account_tax_group.tax_receivable_account_id is 'Tax Receivable Account';

comment on column account_tax_group.advance_tax_payment_account_id is 'Tax Advance Account';

comment on column account_tax_group.country_id is 'Country';

comment on column account_tax_group.create_uid is 'Created by';

comment on column account_tax_group.write_uid is 'Last Updated by';

comment on column account_tax_group.pos_receipt_label is 'PoS receipt label';

comment on column account_tax_group.name is 'Name';

comment on column account_tax_group.preceding_subtotal is 'Preceding Subtotal';

comment on column account_tax_group.create_date is 'Created on';

comment on column account_tax_group.write_date is 'Last Updated on';







drop table if exists account_tax;
create table account_tax
(
    id                               uuid,
    company_id                       uuid not null,
    tax_group_id                     uuid not null,
    cash_basis_transition_account_id uuid,
    country_id                       uuid not null,
    create_uid                       uuid,
    write_uid                        uuid,
    type_tax_use                     varchar not null,
    tax_scope                        varchar,
    amount_type                      varchar not null,
    price_include_override           varchar,
    tax_exigibility                  varchar,
    name                             jsonb   not null,
    description                      jsonb,
    invoice_label                    jsonb,
    invoice_legal_notes              text,
    amount                           numeric not null,
    active                           boolean,
    include_base_amount              boolean,
    is_base_affected                 boolean,
    analytic                         boolean,
    create_date                      timestamp,
    write_date                       timestamp,
    primary key (id),
--     foreign key (company_id) references res_company
--         on delete restrict,
    foreign key (tax_group_id) references account_tax_group
        on delete restrict,
    foreign key (cash_basis_transition_account_id) references account_account
        on delete set null,
    foreign key (country_id) references res_country
        on delete restrict,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_tax is 'Tax';

comment on column account_tax.company_id is 'Company';

comment on column account_tax.tax_group_id is 'Tax Group';

comment on column account_tax.cash_basis_transition_account_id is 'Cash Basis Transition Account';

comment on column account_tax.country_id is 'Country';

comment on column account_tax.create_uid is 'Created by';

comment on column account_tax.write_uid is 'Last Updated by';

comment on column account_tax.type_tax_use is 'Tax Type';

comment on column account_tax.tax_scope is 'Tax Scope';

comment on column account_tax.amount_type is 'Tax Computation';

comment on column account_tax.price_include_override is 'Included in Price';

comment on column account_tax.tax_exigibility is 'Tax Exigibility';

comment on column account_tax.name is 'Tax Name';

comment on column account_tax.description is 'Description';

comment on column account_tax.invoice_label is 'Label on Invoices';

comment on column account_tax.invoice_legal_notes is 'Legal Notes';

comment on column account_tax.amount is 'Amount';

comment on column account_tax.active is 'Active';

comment on column account_tax.include_base_amount is 'Affect Base of Subsequent Taxes';

comment on column account_tax.is_base_affected is 'Base Affected by Previous Taxes';

comment on column account_tax.analytic is 'Include in Analytic Cost';

comment on column account_tax.create_date is 'Created on';

comment on column account_tax.write_date is 'Last Updated on';




drop table if exists account_journal;
create table account_journal
(
    id                       uuid
        primary key,
    alias_id                 uuid,
    default_account_id       uuid
        references account_account
            on delete restrict,
    suspense_account_id      uuid
        references account_account
            on delete restrict,

    currency_id              uuid
                                        references res_currency
                                            on delete set null,
    company_id               uuid       not null,
    profit_account_id        uuid
                                        references account_account
                                            on delete set null,
    loss_account_id          uuid
                                        references account_account
                                            on delete set null,
    bank_account_id          uuid,
    create_uid               uuid
                                        references res_users
                                            on delete set null,
    write_uid                uuid
                                        references res_users
                                            on delete set null,
    color                    integer,
    access_token             varchar,
    code                     varchar(5) not null,
    type                     varchar    not null,
    invoice_reference_type   varchar    not null,
    invoice_reference_model  varchar    not null,
    bank_statements_source   varchar,
    name                     jsonb      not null,
    sequence_override_regex  text,
    active                   boolean,
    autocheck_on_post        boolean,
    restrict_mode_hash_table boolean,
    refund_sequence          boolean,
    payment_sequence         boolean,
    show_on_dashboard        boolean,
    create_date              timestamp,
    write_date               timestamp
--     constraint account_journal_code_company_uniq
--         unique (company_id, code)
);

comment on table account_journal is 'Journal';

comment on column account_journal.alias_id is 'Alias';

comment on column account_journal.default_account_id is 'Default Account';

comment on column account_journal.suspense_account_id is 'Suspense Account';

comment on column account_journal.currency_id is 'Currency';

comment on column account_journal.company_id is 'Company';

comment on column account_journal.profit_account_id is 'Profit Account';

comment on column account_journal.loss_account_id is 'Loss Account';

comment on column account_journal.bank_account_id is 'Bank Account';

comment on column account_journal.create_uid is 'Created by';

comment on column account_journal.write_uid is 'Last Updated by';

comment on column account_journal.color is 'Color Index';

comment on column account_journal.access_token is 'Security Token';

comment on column account_journal.code is 'Short Code';

comment on column account_journal.type is 'Type';

comment on column account_journal.invoice_reference_type is 'Communication Type';

comment on column account_journal.invoice_reference_model is 'Communication Standard';

comment on column account_journal.bank_statements_source is 'Bank Feeds';

comment on column account_journal.name is 'Journal Name';

comment on column account_journal.sequence_override_regex is 'Sequence Override Regex';

comment on column account_journal.active is 'Active';

comment on column account_journal.autocheck_on_post is 'Auto-Check on Post';

comment on column account_journal.restrict_mode_hash_table is 'Secure Posted Entries with Hash';

comment on column account_journal.refund_sequence is 'Dedicated Credit Note Sequence';

comment on column account_journal.payment_sequence is 'Dedicated Payment Sequence';

comment on column account_journal.show_on_dashboard is 'Show journal on dashboard';

comment on column account_journal.create_date is 'Created on';

comment on column account_journal.write_date is 'Last Updated on';

-- comment on constraint account_journal_code_company_uniq on account_journal is 'unique (company_id, code)';

drop table if exists account_incoterms;
create table account_incoterms
(
    id          uuid,
    create_uid  uuid,
    write_uid   uuid,
    code        varchar(3) not null,
    name        jsonb      not null,
    active      boolean,
    create_date timestamp,
    write_date  timestamp,
    primary key (id),
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_incoterms is 'Incoterms';

comment on column account_incoterms.create_uid is 'Created by';

comment on column account_incoterms.write_uid is 'Last Updated by';

comment on column account_incoterms.code is 'Code';

comment on column account_incoterms.name is 'Name';

comment on column account_incoterms.active is 'Active';

comment on column account_incoterms.create_date is 'Created on';

comment on column account_incoterms.write_date is 'Last Updated on';



drop table if exists ir_model;
create table ir_model
(
    id                uuid,
    create_uid        uuid,
    write_uid         uuid,
    model             varchar not null,
    "order"           varchar not null,
    state             varchar,
    name              jsonb   not null,
    info              text,
    transient         boolean,
    create_date       timestamp,
    write_date        timestamp,
    is_mail_thread    boolean,
    is_mail_activity  boolean,
    is_mail_blacklist boolean,
    primary key (id),
    constraint ir_model_obj_name_uniq
        unique (model),
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table ir_model is 'Models';

comment on column ir_model.create_uid is 'Created by';

comment on column ir_model.write_uid is 'Last Updated by';

comment on column ir_model.model is 'Model';

comment on column ir_model."order" is 'Order';

comment on column ir_model.state is 'Type';

comment on column ir_model.name is 'Model Description';

comment on column ir_model.info is 'Information';

comment on column ir_model.transient is 'Transient Model';

comment on column ir_model.create_date is 'Created on';

comment on column ir_model.write_date is 'Last Updated on';

comment on column ir_model.is_mail_thread is 'Has Mail Thread';

comment on column ir_model.is_mail_activity is 'Has Mail Activity';

comment on column ir_model.is_mail_blacklist is 'Has Mail Blacklist';

comment on constraint ir_model_obj_name_uniq on ir_model is 'unique (model)';



drop table if exists ir_actions;
create table ir_actions
(
    id                 uuid,
    binding_model_id   uuid,
    create_uid         uuid,
    write_uid          uuid,
    type               varchar not null,
    path               varchar,
    binding_type       varchar not null,
    binding_view_types varchar,
    name               jsonb   not null,
    help               jsonb,
    create_date        timestamp,
    write_date         timestamp,
    primary key (id),
    constraint ir_actions_path_unique
        unique (path),
    foreign key (binding_model_id) references ir_model
        on delete cascade,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on column ir_actions.binding_model_id is 'Binding Model';

comment on column ir_actions.create_uid is 'Created by';

comment on column ir_actions.write_uid is 'Last Updated by';

comment on column ir_actions.type is 'Action Type';

comment on column ir_actions.path is 'Path to show in the URL';

comment on column ir_actions.binding_type is 'Binding Type';

comment on column ir_actions.binding_view_types is 'Binding View Types';

comment on column ir_actions.name is 'Action Name';

comment on column ir_actions.help is 'Action Description';

comment on column ir_actions.create_date is 'Created on';

comment on column ir_actions.write_date is 'Last Updated on';

comment on constraint ir_actions_path_unique on ir_actions is 'unique(path)';



drop table if exists mail_alias;
create table mail_alias
(
    id                     uuid,
    alias_domain_id        uuid,
    alias_model_id         uuid not null,
    alias_force_thread_id  uuid,
    alias_parent_model_id  uuid,
    alias_parent_thread_id uuid,
    create_uid             uuid,
    write_uid              uuid,
    alias_name             varchar,
    alias_full_name        varchar,
    alias_contact          varchar not null,
    alias_status           varchar,
    alias_bounced_content  jsonb,
    alias_defaults         text    not null,
    alias_incoming_local   boolean,
    create_date            timestamp,
    write_date             timestamp,
    primary key (id),
    foreign key (alias_domain_id) references mail_alias_domain
        on delete restrict,
    foreign key (alias_model_id) references ir_model
        on delete cascade,
    foreign key (alias_parent_model_id) references ir_model
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table mail_alias is 'Email Aliases';

comment on column mail_alias.alias_domain_id is 'Alias Domain';

comment on column mail_alias.alias_model_id is 'Aliased Model';

comment on column mail_alias.alias_force_thread_id is 'Record Thread ID';

comment on column mail_alias.alias_parent_model_id is 'Parent Model';

comment on column mail_alias.alias_parent_thread_id is 'Parent Record Thread ID';

comment on column mail_alias.create_uid is 'Created by';

comment on column mail_alias.write_uid is 'Last Updated by';

comment on column mail_alias.alias_name is 'Alias Name';

comment on column mail_alias.alias_full_name is 'Alias Email';

comment on column mail_alias.alias_contact is 'Alias Contact Security';

comment on column mail_alias.alias_status is 'Alias Status';

comment on column mail_alias.alias_bounced_content is 'Custom Bounced Message';

comment on column mail_alias.alias_defaults is 'Default Values';

comment on column mail_alias.alias_incoming_local is 'Local-part based incoming detection';

comment on column mail_alias.create_date is 'Created on';

comment on column mail_alias.write_date is 'Last Updated on';


drop table if exists ir_attachment;
create table ir_attachment
(
    id            uuid,
    res_id        uuid,
    company_id    uuid,
    file_size     integer,
    create_uid    uuid,
    write_uid     uuid,
    name          varchar not null,
    res_model     varchar,
    res_field     varchar,
    type          varchar not null,
    url           varchar(1024),
    access_token  varchar,
    store_fname   varchar,
    checksum      varchar(40),
    mimetype      varchar,
    description   text,
    index_content text,
    public        boolean,
    create_date   timestamp,
    write_date    timestamp,
    db_datas      bytea,
    original_id   uuid,
    primary key (id),
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null,
    foreign key (original_id) references ir_attachment
        on delete set null
);

comment on table ir_attachment is 'Attachment';

comment on column ir_attachment.res_id is 'Resource ID';

comment on column ir_attachment.company_id is 'Company';

comment on column ir_attachment.file_size is 'File Size';

comment on column ir_attachment.create_uid is 'Created by';

comment on column ir_attachment.write_uid is 'Last Updated by';

comment on column ir_attachment.name is 'Name';

comment on column ir_attachment.res_model is 'Resource Model';

comment on column ir_attachment.res_field is 'Resource Field';

comment on column ir_attachment.type is 'Type';

comment on column ir_attachment.url is 'Url';

comment on column ir_attachment.access_token is 'Access Token';

comment on column ir_attachment.store_fname is 'Stored Filename';

comment on column ir_attachment.checksum is 'Checksum/SHA1';

comment on column ir_attachment.mimetype is 'Mime Type';

comment on column ir_attachment.description is 'Description';

comment on column ir_attachment.index_content is 'Indexed Content';

comment on column ir_attachment.public is 'Is public document';

comment on column ir_attachment.create_date is 'Created on';

comment on column ir_attachment.write_date is 'Last Updated on';

comment on column ir_attachment.db_datas is 'Database Data';

comment on column ir_attachment.original_id is 'Original (unoptimized, unresized) attachment';



drop table if exists res_bank;
create table res_bank
(
    id          uuid,
    state       uuid,
    country     uuid,
    create_uid  uuid,
    write_uid   uuid,
    name        varchar not null,
    street      varchar,
    street2     varchar,
    zip         varchar,
    city        varchar,
    email       varchar,
    phone       varchar,
    bic         varchar,
    active      boolean,
    create_date timestamp,
    write_date  timestamp,
    primary key (id),
    foreign key (state) references res_country_state
        on delete set null,
    foreign key (country) references res_country
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table res_bank is 'Bank';

comment on column res_bank.state is 'Fed. State';

comment on column res_bank.country is 'Country';

comment on column res_bank.create_uid is 'Created by';

comment on column res_bank.write_uid is 'Last Updated by';

comment on column res_bank.name is 'Name';

comment on column res_bank.street is 'Street';

comment on column res_bank.street2 is 'Street2';

comment on column res_bank.zip is 'Zip';

comment on column res_bank.city is 'City';

comment on column res_bank.email is 'Email';

comment on column res_bank.phone is 'Phone';

comment on column res_bank.bic is 'Bank Identifier Code';

comment on column res_bank.active is 'Active';

comment on column res_bank.create_date is 'Created on';

comment on column res_bank.write_date is 'Last Updated on';


drop table if exists res_partner_bank;
create table res_partner_bank
(
    id                         uuid,
    partner_id                 uuid not null,
    bank_id                    uuid,
    currency_id                uuid,
    company_id                 uuid,
    create_uid                 uuid,
    write_uid                  uuid,
    acc_number                 varchar not null,
    sanitized_acc_number       varchar,
    acc_holder_name            varchar,
    active                     boolean,
    allow_out_payment          boolean,
    create_date                timestamp,
    write_date                 timestamp,
    aba_routing                varchar,
    has_iban_warning           boolean,
    has_money_transfer_warning boolean,
    primary key (id),
    constraint res_partner_bank_unique_number
        unique (sanitized_acc_number, partner_id),
    foreign key (partner_id) references res_partner
        on delete cascade,
    foreign key (bank_id) references res_bank
        on delete set null,
    foreign key (currency_id) references res_currency
        on delete set null,
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table res_partner_bank is 'Bank Accounts';

comment on column res_partner_bank.partner_id is 'Account Holder';

comment on column res_partner_bank.bank_id is 'Bank';

comment on column res_partner_bank.currency_id is 'Currency';

comment on column res_partner_bank.company_id is 'Company';

comment on column res_partner_bank.create_uid is 'Created by';

comment on column res_partner_bank.write_uid is 'Last Updated by';

comment on column res_partner_bank.acc_number is 'Account Number';

comment on column res_partner_bank.sanitized_acc_number is 'Sanitized Account Number';

comment on column res_partner_bank.acc_holder_name is 'Account Holder Name';

comment on column res_partner_bank.active is 'Active';

comment on column res_partner_bank.allow_out_payment is 'Send Money';

comment on column res_partner_bank.create_date is 'Created on';

comment on column res_partner_bank.write_date is 'Last Updated on';

comment on column res_partner_bank.aba_routing is 'ABA/Routing';

comment on column res_partner_bank.has_iban_warning is 'Has Iban Warning';

comment on column res_partner_bank.has_money_transfer_warning is 'Has Money Transfer Warning';

comment on constraint res_partner_bank_unique_number on res_partner_bank is 'unique(sanitized_acc_number, partner_id)';





drop table if  exists ir_module_category;
create table ir_module_category
(
    id          uuid,
    create_uid  uuid,
    create_date timestamp,
    write_date  timestamp,
    write_uid   uuid,
    parent_id   uuid,
    name        jsonb not null,
    description jsonb,
    visible     boolean,
    exclusive   boolean,
    primary key (id),
    foreign key (parent_id) references ir_module_category
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on column ir_module_category.description is 'Description';

comment on column ir_module_category.visible is 'Visible';

comment on column ir_module_category.exclusive is 'Exclusive';




create table ir_act_report_xml
(
	paperformat_id uuid
		references report_paperformat
			on delete set null,
	model varchar not null,
	report_type varchar not null,
	report_name varchar not null,
	report_file varchar,
	attachment varchar,
	domain varchar,
	print_report_name jsonb,
	multi boolean,
	attachment_use boolean,
	is_invoice_report boolean,
	primary key (id),
	constraint ir_act_report_xml_path_unique
		unique (path)
)
inherits (ir_actions);

comment on column ir_act_report_xml.paperformat_id is 'Paper Format';

comment on column ir_act_report_xml.model is 'Model Name';

comment on column ir_act_report_xml.report_type is 'Report Type';

comment on column ir_act_report_xml.report_name is 'Template Name';

comment on column ir_act_report_xml.report_file is 'Report File';

comment on column ir_act_report_xml.attachment is 'Save as Attachment Prefix';

comment on column ir_act_report_xml.domain is 'Filter domain';

comment on column ir_act_report_xml.print_report_name is 'Printed Report Name';

comment on column ir_act_report_xml.multi is 'On Multiple Doc.';

comment on column ir_act_report_xml.attachment_use is 'Reload from Attachment';

comment on column ir_act_report_xml.is_invoice_report is 'Invoice report';

comment on constraint ir_act_report_xml_path_unique on ir_act_report_xml is 'unique(path)';









drop table if exists ir_module_module;
create table ir_module_module
(
    id                uuid,
    create_uid        uuid,
    create_date       timestamp,
    write_date        timestamp,
    write_uid         uuid,
    website           varchar,
    summary           jsonb,
    name              varchar not null,
    author            varchar,
    icon              varchar,
    state             varchar(16),
    latest_version    varchar,
    shortdesc         jsonb,
    category_id       uuid,
    description       jsonb,
    application       boolean default false,
    demo              boolean default false,
    web               boolean default false,
    license           varchar(32),
    auto_install      boolean default false,
    to_buy            boolean default false,
    maintainer        varchar,
    published_version varchar,
    url               varchar,
    contributors      text,
    menus_by_module   text,
    reports_by_module text,
    views_by_module   text,
    module_type       varchar,
    imported          boolean,
    primary key (id),
    constraint ir_module_module_name_uniq
        unique (name),
    foreign key (category_id) references ir_module_category
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on column ir_module_module.maintainer is 'Maintainer';

comment on column ir_module_module.published_version is 'Published Version';

comment on column ir_module_module.url is 'URL';

comment on column ir_module_module.contributors is 'Contributors';

comment on column ir_module_module.menus_by_module is 'Menus';

comment on column ir_module_module.reports_by_module is 'Reports';

comment on column ir_module_module.views_by_module is 'Views';

comment on column ir_module_module.module_type is 'Module Type';

comment on column ir_module_module.imported is 'Imported Module';

comment on constraint ir_module_module_name_uniq on ir_module_module is 'UNIQUE (name)';




drop table if exists payment_provider;
create table payment_provider
(
    id                            uuid,
    company_id                    uuid not null,
    redirect_form_view_id         uuid,
    inline_form_view_id           uuid,
    token_inline_form_view_id     uuid,
    express_checkout_form_view_id uuid,
    color                         integer,
    module_id                     uuid,
    create_uid                    uuid,
    write_uid                     uuid,
    code                          varchar not null,
    state                         varchar not null,
    name                          jsonb   not null,
    pre_msg                       jsonb,
    pending_msg                   jsonb,
    auth_msg                      jsonb,
    done_msg                      jsonb,
    cancel_msg                    jsonb,
    maximum_amount                numeric,
    is_published                  boolean,
    allow_tokenization            boolean,
    capture_manually              boolean,
    allow_express_checkout        boolean,
    create_date                   timestamp,
    write_date                    timestamp,
    primary key (id),
--     foreign key (company_id) references res_company
--         on delete restrict,
    foreign key (redirect_form_view_id) references ir_ui_view
        on delete restrict,
    foreign key (inline_form_view_id) references ir_ui_view
        on delete restrict,
    foreign key (token_inline_form_view_id) references ir_ui_view
        on delete restrict,
    foreign key (express_checkout_form_view_id) references ir_ui_view
        on delete restrict,
    foreign key (module_id) references ir_module_module
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table payment_provider is 'Payment Provider';

comment on column payment_provider.company_id is 'Company';

comment on column payment_provider.redirect_form_view_id is 'Redirect Form Template';

comment on column payment_provider.inline_form_view_id is 'Inline Form Template';

comment on column payment_provider.token_inline_form_view_id is 'Token Inline Form Template';

comment on column payment_provider.express_checkout_form_view_id is 'Express Checkout Form Template';

comment on column payment_provider.color is 'Color';

comment on column payment_provider.module_id is 'Corresponding Module';

comment on column payment_provider.create_uid is 'Created by';

comment on column payment_provider.write_uid is 'Last Updated by';

comment on column payment_provider.code is 'Code';

comment on column payment_provider.state is 'State';

comment on column payment_provider.name is 'Name';

comment on column payment_provider.pre_msg is 'Help Message';

comment on column payment_provider.pending_msg is 'Pending Message';

comment on column payment_provider.auth_msg is 'Authorize Message';

comment on column payment_provider.done_msg is 'Done Message';

comment on column payment_provider.cancel_msg is 'Cancelled Message';

comment on column payment_provider.maximum_amount is 'Maximum Amount';

comment on column payment_provider.is_published is 'Published';

comment on column payment_provider.allow_tokenization is 'Allow Saving Payment Methods';

comment on column payment_provider.capture_manually is 'Capture Amount Manually';

comment on column payment_provider.allow_express_checkout is 'Allow Express Checkout';

comment on column payment_provider.create_date is 'Created on';

comment on column payment_provider.write_date is 'Last Updated on';

drop table if exists payment_method;
create table payment_method
(
    id                        uuid,
    primary_payment_method_id uuid,
    create_uid                uuid,
    write_uid                 uuid,
    code                      varchar not null,
    support_refund            varchar not null,
    name                      jsonb   not null,
    active                    boolean,
    support_tokenization      boolean,
    support_express_checkout  boolean,
    create_date               timestamp,
    write_date                timestamp,
    primary key (id),
    foreign key (primary_payment_method_id) references payment_method
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table payment_method is 'Payment Method';

comment on column payment_method.primary_payment_method_id is 'Primary Payment Method';

comment on column payment_method.create_uid is 'Created by';

comment on column payment_method.write_uid is 'Last Updated by';

comment on column payment_method.code is 'Code';

comment on column payment_method.support_refund is 'Refund';

comment on column payment_method.name is 'Name';

comment on column payment_method.active is 'Active';

comment on column payment_method.support_tokenization is 'Tokenization';

comment on column payment_method.support_express_checkout is 'Express Checkout';

comment on column payment_method.create_date is 'Created on';

comment on column payment_method.write_date is 'Last Updated on';


drop table if exists payment_token;
create table payment_token
(
    id                uuid,
    provider_id       uuid not null,
    company_id        uuid,
    payment_method_id uuid not null,
    partner_id        uuid not null,
    create_uid        uuid,
    write_uid         uuid,
    payment_details   varchar,
    provider_ref      varchar not null,
    active            boolean,
    create_date       timestamp,
    write_date        timestamp,
    primary key (id),
    foreign key (provider_id) references payment_provider
        on delete restrict,
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (payment_method_id) references payment_method
        on delete restrict,
    foreign key (partner_id) references res_partner
        on delete restrict,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table payment_token is 'Payment Token';

comment on column payment_token.provider_id is 'Provider';

comment on column payment_token.company_id is 'Company';

comment on column payment_token.payment_method_id is 'Payment Method';

comment on column payment_token.partner_id is 'Partner';

comment on column payment_token.create_uid is 'Created by';

comment on column payment_token.write_uid is 'Last Updated by';

comment on column payment_token.payment_details is 'Payment Details';

comment on column payment_token.provider_ref is 'Provider Reference';

comment on column payment_token.active is 'Active';

comment on column payment_token.create_date is 'Created on';

comment on column payment_token.write_date is 'Last Updated on';









drop table if exists account_payment_method;
create table account_payment_method
(
    id           uuid,
    create_uid   uuid,
    write_uid    uuid,
    code         varchar not null,
    payment_type varchar not null,
    name         jsonb   not null,
    create_date  timestamp,
    write_date   timestamp,
    primary key (id),
    constraint account_payment_method_name_code_unique
        unique (code, payment_type),
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_payment_method is 'Payment Methods';

comment on column account_payment_method.create_uid is 'Created by';

comment on column account_payment_method.write_uid is 'Last Updated by';

comment on column account_payment_method.code is 'Code';

comment on column account_payment_method.payment_type is 'Payment Type';

comment on column account_payment_method.name is 'Name';

comment on column account_payment_method.create_date is 'Created on';

comment on column account_payment_method.write_date is 'Last Updated on';

comment on constraint account_payment_method_name_code_unique on account_payment_method is 'unique (code, payment_type)';




drop table if exists account_payment_method_line;
create table account_payment_method_line
(
    id                  uuid,
    payment_method_id   uuid not null,
    payment_account_id  uuid,
    journal_id          uuid,
    create_uid          uuid,
    write_uid           uuid,
    name                varchar,
    create_date         timestamp,
    write_date          timestamp,
    payment_provider_id uuid,
    primary key (id),
    foreign key (payment_method_id) references account_payment_method
        on delete restrict,
    foreign key (payment_account_id) references account_account
        on delete restrict,
    foreign key (journal_id) references account_journal
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null,
    foreign key (payment_provider_id) references payment_provider
        on delete set null
);

comment on table account_payment_method_line is 'Payment Methods';

comment on column account_payment_method_line.payment_method_id is 'Payment Method';

comment on column account_payment_method_line.payment_account_id is 'Payment Account';

comment on column account_payment_method_line.journal_id is 'Journal';

comment on column account_payment_method_line.create_uid is 'Created by';

comment on column account_payment_method_line.write_uid is 'Last Updated by';

comment on column account_payment_method_line.name is 'Name';

comment on column account_payment_method_line.create_date is 'Created on';

comment on column account_payment_method_line.write_date is 'Last Updated on';

comment on column account_payment_method_line.payment_provider_id is 'Payment Provider';




drop table if exists account_bank_statement;
create table account_bank_statement
(
    id               uuid,
    company_id       uuid,
    journal_id       uuid,
    create_uid       uuid,
    write_uid        uuid,
    name             varchar,
    reference        varchar,
    first_line_index varchar,
    date             date,
    balance_start    numeric,
    balance_end      numeric,
    balance_end_real numeric,
    is_complete      boolean,
    create_date      timestamp,
    write_date       timestamp,
    primary key (id),
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (journal_id) references account_journal
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_bank_statement is 'Bank Statement';

comment on column account_bank_statement.company_id is 'Company';

comment on column account_bank_statement.journal_id is 'Journal';

comment on column account_bank_statement.create_uid is 'Created by';

comment on column account_bank_statement.write_uid is 'Last Updated by';

comment on column account_bank_statement.name is 'Reference';

comment on column account_bank_statement.reference is 'External Reference';

comment on column account_bank_statement.first_line_index is 'First Line Index';

comment on column account_bank_statement.date is 'Date';

comment on column account_bank_statement.balance_start is 'Starting Balance';

comment on column account_bank_statement.balance_end is 'Computed Balance';

comment on column account_bank_statement.balance_end_real is 'Ending Balance';

comment on column account_bank_statement.is_complete is 'Is Complete';

comment on column account_bank_statement.create_date is 'Created on';

comment on column account_bank_statement.write_date is 'Last Updated on';




drop table if exists account_reconcile_model;
create table account_reconcile_model
(
	id uuid,
	company_id uuid not null,
	past_months_limit integer,
	create_uid uuid,
	write_uid uuid,
	rule_type varchar not null,
	matching_order varchar not null,
	counterpart_type varchar,
	match_nature varchar not null,
	match_amount varchar,
	match_label varchar,
	match_label_param varchar,
	match_note varchar,
	match_note_param varchar,
	match_transaction_type varchar,
	match_transaction_type_param varchar,
	payment_tolerance_type varchar not null,
	decimal_separator varchar,
	name jsonb not null,
	active boolean,
	auto_reconcile boolean,
	to_check boolean,
	match_text_location_label boolean,
	match_text_location_note boolean,
	match_text_location_reference boolean,
	match_same_currency boolean,
	allow_payment_tolerance boolean,
	match_partner boolean,
	create_date timestamp,
	write_date timestamp,
	match_amount_min double precision,
	match_amount_max double precision,
	payment_tolerance_param double precision,
	primary key (id),
	constraint account_reconcile_model_name_unique
		unique (name, company_id),
-- 	foreign key (company_id) references res_company
-- 		on delete restrict,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table account_reconcile_model is 'Preset to create journal entries during a invoices and payments matching';

comment on column account_reconcile_model.company_id is 'Company';

comment on column account_reconcile_model.past_months_limit is 'Search Months Limit';

comment on column account_reconcile_model.create_uid is 'Created by';

comment on column account_reconcile_model.write_uid is 'Last Updated by';

comment on column account_reconcile_model.rule_type is 'Type';

comment on column account_reconcile_model.matching_order is 'Matching Order';

comment on column account_reconcile_model.counterpart_type is 'Counterpart Type';

comment on column account_reconcile_model.match_nature is 'Amount Type';

comment on column account_reconcile_model.match_amount is 'Amount Condition';

comment on column account_reconcile_model.match_label is 'Label';

comment on column account_reconcile_model.match_label_param is 'Label Parameter';

comment on column account_reconcile_model.match_note is 'Note';

comment on column account_reconcile_model.match_note_param is 'Note Parameter';

comment on column account_reconcile_model.match_transaction_type is 'Transaction Type';

comment on column account_reconcile_model.match_transaction_type_param is 'Transaction Type Parameter';

comment on column account_reconcile_model.payment_tolerance_type is 'Payment Tolerance Type';

comment on column account_reconcile_model.decimal_separator is 'Decimal Separator';

comment on column account_reconcile_model.name is 'Name';

comment on column account_reconcile_model.active is 'Active';

comment on column account_reconcile_model.auto_reconcile is 'Auto-validate';

comment on column account_reconcile_model.to_check is 'To Check';

comment on column account_reconcile_model.match_text_location_label is 'Match Text Location Label';

comment on column account_reconcile_model.match_text_location_note is 'Match Text Location Note';

comment on column account_reconcile_model.match_text_location_reference is 'Match Text Location Reference';

comment on column account_reconcile_model.match_same_currency is 'Same Currency';

comment on column account_reconcile_model.allow_payment_tolerance is 'Payment Tolerance';

comment on column account_reconcile_model.match_partner is 'Partner is Set';

comment on column account_reconcile_model.create_date is 'Created on';

comment on column account_reconcile_model.write_date is 'Last Updated on';

comment on column account_reconcile_model.match_amount_min is 'Amount Min Parameter';

comment on column account_reconcile_model.match_amount_max is 'Amount Max Parameter';

comment on column account_reconcile_model.payment_tolerance_param is 'Gap';

comment on constraint account_reconcile_model_name_unique on account_reconcile_model is 'unique(name, company_id)';






drop table if exists account_tax_repartition_line;
create table account_tax_repartition_line
(
	id uuid,
	account_id uuid,
	tax_id uuid,
	company_id uuid,
	create_uid uuid,
	write_uid uuid,
	repartition_type varchar not null,
	document_type varchar not null,
	use_in_tax_closing boolean,
	create_date timestamp,
	write_date timestamp,
	factor_percent double precision not null,
	primary key (id),
	foreign key (account_id) references account_account
		on delete set null,
	foreign key (tax_id) references account_tax
		on delete cascade,
-- 	foreign key (company_id) references res_company
-- 		on delete set null,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table account_tax_repartition_line is 'Tax Repartition Line';

comment on column account_tax_repartition_line.account_id is 'Account';

comment on column account_tax_repartition_line.tax_id is 'Tax';

comment on column account_tax_repartition_line.company_id is 'Company';

comment on column account_tax_repartition_line.create_uid is 'Created by';

comment on column account_tax_repartition_line.write_uid is 'Last Updated by';

comment on column account_tax_repartition_line.repartition_type is 'Based On';

comment on column account_tax_repartition_line.document_type is 'Related to';

comment on column account_tax_repartition_line.use_in_tax_closing is 'Tax Closing Entry';

comment on column account_tax_repartition_line.create_date is 'Created on';

comment on column account_tax_repartition_line.write_date is 'Last Updated on';

comment on column account_tax_repartition_line.factor_percent is '%';


drop table if exists account_tax_repartition_line;
create table account_tax_repartition_line
(
	id uuid,
	account_id uuid,
	tax_id uuid,
	company_id uuid,
	create_uid uuid,
	write_uid uuid,
	repartition_type varchar not null,
	document_type varchar not null,
	use_in_tax_closing boolean,
	create_date timestamp,
	write_date timestamp,
	factor_percent double precision not null,
	primary key (id),
	foreign key (account_id) references account_account
		on delete set null,
	foreign key (tax_id) references account_tax
		on delete cascade,
-- 	foreign key (company_id) references res_company
-- 		on delete set null,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table account_tax_repartition_line is 'Tax Repartition Line';

comment on column account_tax_repartition_line.account_id is 'Account';

comment on column account_tax_repartition_line.tax_id is 'Tax';

comment on column account_tax_repartition_line.company_id is 'Company';

comment on column account_tax_repartition_line.create_uid is 'Created by';

comment on column account_tax_repartition_line.write_uid is 'Last Updated by';

comment on column account_tax_repartition_line.repartition_type is 'Based On';

comment on column account_tax_repartition_line.document_type is 'Related to';

comment on column account_tax_repartition_line.use_in_tax_closing is 'Tax Closing Entry';

comment on column account_tax_repartition_line.create_date is 'Created on';

comment on column account_tax_repartition_line.write_date is 'Last Updated on';

comment on column account_tax_repartition_line.factor_percent is '%';



drop table if exists uom_category;
create table uom_category
(
	id uuid,
	create_uid uuid,
	write_uid uuid,
	name jsonb not null,
	create_date timestamp,
	write_date timestamp,
	primary key (id),
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table uom_category is 'Product UoM Categories';

comment on column uom_category.create_uid is 'Created by';

comment on column uom_category.write_uid is 'Last Updated by';

comment on column uom_category.name is 'Unit of Measure Category';

comment on column uom_category.create_date is 'Created on';

comment on column uom_category.write_date is 'Last Updated on';




drop table if exists uom_uom;
create table uom_uom
(
	id uuid,
	category_id uuid not null,
	create_uid uuid,
	write_uid uuid,
	uom_type varchar not null,
	name jsonb not null,
	factor numeric not null,
	rounding numeric not null,
	active boolean,
	create_date timestamp,
	write_date timestamp,
	primary key (id),
	foreign key (category_id) references uom_category
		on delete restrict,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null,
	constraint uom_uom_factor_gt_zero
		check (factor <> (0)::numeric),
	constraint uom_uom_rounding_gt_zero
		check (rounding > (0)::numeric),
	constraint uom_uom_factor_reference_is_one
		check ((((uom_type)::text = 'reference'::text) AND (factor = 1.0)) OR ((uom_type)::text <> 'reference'::text))
);

comment on table uom_uom is 'Product Unit of Measure';

comment on column uom_uom.category_id is 'Category';

comment on column uom_uom.create_uid is 'Created by';

comment on column uom_uom.write_uid is 'Last Updated by';

comment on column uom_uom.uom_type is 'Type';

comment on column uom_uom.name is 'Unit of Measure';

comment on column uom_uom.factor is 'Ratio';

comment on column uom_uom.rounding is 'Rounding Precision';

comment on column uom_uom.active is 'Active';

comment on column uom_uom.create_date is 'Created on';

comment on column uom_uom.write_date is 'Last Updated on';

comment on constraint uom_uom_factor_gt_zero on uom_uom is 'CHECK (factor!=0)';

comment on constraint uom_uom_rounding_gt_zero on uom_uom is 'CHECK (rounding>0)';

comment on constraint uom_uom_factor_reference_is_one on uom_uom is 'CHECK((uom_type = ''reference'' AND factor = 1.0) OR (uom_type != ''reference''))';


drop table if exists product_category;
create table product_category
(
	id uuid,
	parent_id uuid,
	create_uid uuid,
	write_uid uuid,
	name varchar not null,
	complete_name varchar,
	parent_path varchar,
	product_properties_definition jsonb,
	create_date timestamp,
	write_date timestamp,
	property_account_income_categ_id jsonb,
	property_account_expense_categ_id jsonb,
	primary key (id),
	foreign key (parent_id) references product_category
		on delete cascade,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table product_category is 'Product Category';

comment on column product_category.parent_id is 'Parent Category';

comment on column product_category.create_uid is 'Created by';

comment on column product_category.write_uid is 'Last Updated by';

comment on column product_category.name is 'Name';

comment on column product_category.complete_name is 'Complete Name';

comment on column product_category.parent_path is 'Parent Path';

comment on column product_category.product_properties_definition is 'Product Properties';

comment on column product_category.create_date is 'Created on';

comment on column product_category.write_date is 'Last Updated on';

comment on column product_category.property_account_income_categ_id is 'Income Account';

comment on column product_category.property_account_expense_categ_id is 'Expense Account';


drop table if exists product_template;
create table product_template
(
	id uuid,
	categ_id uuid not null,
	uom_id uuid not null,
	uom_po_id uuid not null,
	company_id uuid,
	color integer,
	create_uid uuid,
	write_uid uuid,
	type varchar not null,
	service_tracking varchar not null,
	default_code varchar,
	name jsonb not null,
	description jsonb,
	description_purchase jsonb,
	description_sale jsonb,
	product_properties jsonb,
	list_price numeric,
	volume numeric,
	weight numeric,
	sale_ok boolean,
	purchase_ok boolean,
	active boolean,
	can_image_1024_be_zoomed boolean,
	has_configurable_attributes boolean,
	is_favorite boolean,
	create_date timestamp,
	write_date timestamp,
	property_account_income_id jsonb,
	property_account_expense_id jsonb,
	purchase_method varchar,
	purchase_line_warn varchar not null,
	purchase_line_warn_msg text,
	primary key (id),
	foreign key (categ_id) references product_category
		on delete restrict,
	foreign key (uom_id) references uom_uom
		on delete restrict,
	foreign key (uom_po_id) references uom_uom
		on delete restrict,
-- 	foreign key (company_id) references res_company
-- 		on delete set null,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table product_template is 'Product';

comment on column product_template.categ_id is 'Product Category';

comment on column product_template.uom_id is 'Unit of Measure';

comment on column product_template.uom_po_id is 'Purchase Unit';

comment on column product_template.company_id is 'Company';

comment on column product_template.color is 'Color Index';

comment on column product_template.create_uid is 'Created by';

comment on column product_template.write_uid is 'Last Updated by';

comment on column product_template.type is 'Product Type';

comment on column product_template.service_tracking is 'Create on Order';

comment on column product_template.default_code is 'Internal Reference';

comment on column product_template.name is 'Name';

comment on column product_template.description is 'Description';

comment on column product_template.description_purchase is 'Purchase Description';

comment on column product_template.description_sale is 'Sales Description';

comment on column product_template.product_properties is 'Properties';

comment on column product_template.list_price is 'Sales Price';

comment on column product_template.volume is 'Volume';

comment on column product_template.weight is 'Weight';

comment on column product_template.sale_ok is 'Sales';

comment on column product_template.purchase_ok is 'Purchase';

comment on column product_template.active is 'Active';

comment on column product_template.can_image_1024_be_zoomed is 'Can Image 1024 be zoomed';

comment on column product_template.has_configurable_attributes is 'Is a configurable product';

comment on column product_template.is_favorite is 'Favorite';

comment on column product_template.create_date is 'Created on';

comment on column product_template.write_date is 'Last Updated on';

comment on column product_template.property_account_income_id is 'Income Account';

comment on column product_template.property_account_expense_id is 'Expense Account';

comment on column product_template.purchase_method is 'Control Policy';

comment on column product_template.purchase_line_warn is 'Purchase Order Line Warning';

comment on column product_template.purchase_line_warn_msg is 'Message for Purchase Order Line';



drop table if exists product_product;
create table product_product
(
	id uuid,
	product_tmpl_id uuid not null,
	create_uid uuid,
	write_uid uuid,
	default_code varchar,
	barcode varchar,
	combination_indices varchar,
	standard_price jsonb,
	volume numeric,
	weight numeric,
	active boolean,
	can_image_variant_1024_be_zoomed boolean,
	write_date timestamp,
	create_date timestamp,
	primary key (id),
	foreign key (product_tmpl_id) references product_template
		on delete cascade,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table product_product is 'Product Variant';

comment on column product_product.product_tmpl_id is 'Product Template';

comment on column product_product.create_uid is 'Created by';

comment on column product_product.write_uid is 'Last Updated by';

comment on column product_product.default_code is 'Internal Reference';

comment on column product_product.barcode is 'Barcode';

comment on column product_product.combination_indices is 'Combination Indices';

comment on column product_product.standard_price is 'Cost';

comment on column product_product.volume is 'Volume';

comment on column product_product.weight is 'Weight';

comment on column product_product.active is 'Active';

comment on column product_product.can_image_variant_1024_be_zoomed is 'Can Variant Image 1024 be zoomed';

comment on column product_product.write_date is 'Write Date';

comment on column product_product.create_date is 'Created on';



drop table if exists res_country_group;
create table res_country_group
(
	id uuid,
	create_uid uuid,
	write_uid uuid,
	name jsonb not null,
	create_date timestamp,
	write_date timestamp,
	primary key (id),
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table res_country_group is 'Country Group';

comment on column res_country_group.create_uid is 'Created by';

comment on column res_country_group.write_uid is 'Last Updated by';

comment on column res_country_group.name is 'Name';

comment on column res_country_group.create_date is 'Created on';

comment on column res_country_group.write_date is 'Last Updated on';




drop table if exists account_fiscal_position;
create table account_fiscal_position
(
    id               uuid,
    company_id       uuid not null,
    country_id       uuid,
    country_group_id uuid,
    create_uid       uuid,
    write_uid        uuid,
    zip_from         varchar,
    zip_to           varchar,
    foreign_vat      varchar,
    name             jsonb   not null,
    note             jsonb,
    active           boolean,
    auto_apply       boolean,
    vat_required     boolean,
    create_date      timestamp,
    write_date       timestamp,
    primary key (id),
--     foreign key (company_id) references res_company
--         on delete restrict,
    foreign key (country_id) references res_country
        on delete set null,
    foreign key (country_group_id) references res_country_group
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_fiscal_position is 'Fiscal Position';

comment on column account_fiscal_position.company_id is 'Company';

comment on column account_fiscal_position.country_id is 'Country';

comment on column account_fiscal_position.country_group_id is 'Country Group';

comment on column account_fiscal_position.create_uid is 'Created by';

comment on column account_fiscal_position.write_uid is 'Last Updated by';

comment on column account_fiscal_position.zip_from is 'Zip Range From';

comment on column account_fiscal_position.zip_to is 'Zip Range To';

comment on column account_fiscal_position.foreign_vat is 'Foreign Tax ID';

comment on column account_fiscal_position.name is 'Fiscal Position';

comment on column account_fiscal_position.note is 'Notes';

comment on column account_fiscal_position.active is 'Active';

comment on column account_fiscal_position.auto_apply is 'Detect Automatically';

comment on column account_fiscal_position.vat_required is 'VAT required';

comment on column account_fiscal_position.create_date is 'Created on';

comment on column account_fiscal_position.write_date is 'Last Updated on';


drop table if exists account_payment_term;
create table account_payment_term
(
    id                             uuid,
    company_id                     uuid,
    discount_days                  integer,
    create_uid                     uuid,
    write_uid                      uuid,
    early_pay_discount_computation varchar,
    name                           jsonb   not null,
    note                           jsonb,
    active                         boolean,
    display_on_invoice             boolean,
    early_discount                 boolean,
    create_date                    timestamp,
    write_date                     timestamp,
    discount_percentage            double precision,
    primary key (id),
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_payment_term is 'Payment Terms';

comment on column account_payment_term.company_id is 'Company';

comment on column account_payment_term.discount_days is 'Discount Days';

comment on column account_payment_term.create_uid is 'Created by';

comment on column account_payment_term.write_uid is 'Last Updated by';

comment on column account_payment_term.early_pay_discount_computation is 'Cash Discount Tax Reduction';

comment on column account_payment_term.name is 'Payment Terms';

comment on column account_payment_term.note is 'Description on the Invoice';

comment on column account_payment_term.active is 'Active';

comment on column account_payment_term.display_on_invoice is 'Show installment dates';

comment on column account_payment_term.early_discount is 'Early Discount';

comment on column account_payment_term.create_date is 'Created on';

comment on column account_payment_term.write_date is 'Last Updated on';

comment on column account_payment_term.discount_percentage is 'Discount %';





drop table if exists purchase_order;
create table purchase_order
(
	id uuid,
	partner_id uuid not null,
	dest_address_id uuid,
	currency_id uuid not null,
	invoice_count integer,
	fiscal_position_id uuid,
	payment_term_id uuid,
	incoterm_id uuid,
	user_id uuid,
	company_id uuid not null,
	create_uid uuid,
	write_uid uuid,
	access_token varchar,
	name varchar not null,
	priority varchar,
	origin varchar,
	partner_ref varchar,
	state varchar,
	invoice_status varchar,
	notes text,
	amount_untaxed numeric,
	amount_tax numeric,
	amount_total numeric,
	amount_total_cc numeric,
	currency_rate numeric,
	mail_reminder_confirmed boolean,
	mail_reception_confirmed boolean,
	mail_reception_declined boolean,
	date_order timestamp not null,
	date_approve timestamp,
	date_planned timestamp,
	date_calendar_start timestamp,
	create_date timestamp,
	write_date timestamp,
	primary key (id),
	foreign key (partner_id) references res_partner
		on delete restrict,
	foreign key (dest_address_id) references res_partner
		on delete set null,
	foreign key (currency_id) references res_currency
		on delete restrict,
	foreign key (fiscal_position_id) references account_fiscal_position
		on delete set null,
	foreign key (payment_term_id) references account_payment_term
		on delete set null,
	foreign key (incoterm_id) references account_incoterms
		on delete set null,
	foreign key (user_id) references res_users
		on delete set null,
-- 	foreign key (company_id) references res_company
-- 		on delete restrict,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table purchase_order is 'Purchase Order';

comment on column purchase_order.partner_id is 'Vendor';

comment on column purchase_order.dest_address_id is 'Dropship Address';

comment on column purchase_order.currency_id is 'Currency';

comment on column purchase_order.invoice_count is 'Bill Count';

comment on column purchase_order.fiscal_position_id is 'Fiscal Position';

comment on column purchase_order.payment_term_id is 'Payment Terms';

comment on column purchase_order.incoterm_id is 'Incoterm';

comment on column purchase_order.user_id is 'Buyer';

comment on column purchase_order.company_id is 'Company';

comment on column purchase_order.create_uid is 'Created by';

comment on column purchase_order.write_uid is 'Last Updated by';

comment on column purchase_order.access_token is 'Security Token';

comment on column purchase_order.name is 'Order Reference';

comment on column purchase_order.priority is 'Priority';

comment on column purchase_order.origin is 'Source Document';

comment on column purchase_order.partner_ref is 'Vendor Reference';

comment on column purchase_order.state is 'Status';

comment on column purchase_order.invoice_status is 'Billing Status';

comment on column purchase_order.notes is 'Terms and Conditions';

comment on column purchase_order.amount_untaxed is 'Untaxed Amount';

comment on column purchase_order.amount_tax is 'Taxes';

comment on column purchase_order.amount_total is 'Total';

comment on column purchase_order.amount_total_cc is 'Company Total';

comment on column purchase_order.currency_rate is 'Currency Rate';

comment on column purchase_order.mail_reminder_confirmed is 'Reminder Confirmed';

comment on column purchase_order.mail_reception_confirmed is 'Reception Confirmed';

comment on column purchase_order.mail_reception_declined is 'Reception Declined';

comment on column purchase_order.date_order is 'Order Deadline';

comment on column purchase_order.date_approve is 'Confirmation Date';

comment on column purchase_order.date_planned is 'Expected Arrival';

comment on column purchase_order.date_calendar_start is 'Date Calendar Start';

comment on column purchase_order.create_date is 'Created on';

comment on column purchase_order.write_date is 'Last Updated on';


drop table if exists product_packaging;
create table product_packaging
(
	id uuid,
	product_id uuid not null,
	company_id uuid,
	create_uid uuid,
	write_uid uuid,
	name varchar not null,
	barcode varchar,
	qty numeric,
	create_date timestamp,
	write_date timestamp,
	purchase boolean,
	primary key (id),
	constraint product_packaging_barcode_uniq
		unique (barcode),
	foreign key (product_id) references product_product
		on delete cascade,
-- 	foreign key (company_id) references res_company
-- 		on delete set null,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null,
	constraint product_packaging_positive_qty
		check (qty > (0)::numeric)
);

comment on table product_packaging is 'Product Packaging';

comment on column product_packaging.product_id is 'Product';

comment on column product_packaging.company_id is 'Company';

comment on column product_packaging.create_uid is 'Created by';

comment on column product_packaging.write_uid is 'Last Updated by';

comment on column product_packaging.name is 'Product Packaging';

comment on column product_packaging.barcode is 'Barcode';

comment on column product_packaging.qty is 'Contained Quantity';

comment on column product_packaging.create_date is 'Created on';

comment on column product_packaging.write_date is 'Last Updated on';

comment on column product_packaging.purchase is 'Purchase';

comment on constraint product_packaging_barcode_uniq on product_packaging is 'unique(barcode)';

comment on constraint product_packaging_positive_qty on product_packaging is 'CHECK(qty > 0)';


drop table if exists purchase_order_line;
create table purchase_order_line
(
	id uuid,
	product_uom uuid,
	product_id uuid,
	order_id uuid not null,
	company_id uuid,
	partner_id uuid,
	currency_id uuid,
	product_packaging_id uuid,
	create_uid uuid,
	write_uid uuid,
	state varchar,
	qty_received_method varchar,
	display_type varchar,
	analytic_distribution jsonb,
	name text not null,
	product_qty numeric not null,
	discount numeric,
	price_unit numeric not null,
	price_subtotal numeric,
	price_total numeric,
	qty_invoiced numeric,
	qty_received numeric,
	qty_received_manual numeric,
	qty_to_invoice numeric,
	is_downpayment boolean,
	date_planned timestamp,
	create_date timestamp,
	write_date timestamp,
	product_uom_qty double precision,
	price_tax double precision,
	product_packaging_qty double precision,
	primary key (id),
	foreign key (product_uom) references uom_uom
		on delete set null,
	foreign key (product_id) references product_product
		on delete set null,
	foreign key (order_id) references purchase_order
		on delete cascade,
-- 	foreign key (company_id) references res_company
-- 		on delete set null,
	foreign key (partner_id) references res_partner
		on delete set null,
	foreign key (currency_id) references res_currency
		on delete set null,
	foreign key (product_packaging_id) references product_packaging
		on delete set null,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null,
	constraint purchase_order_line_accountable_required_fields
		check ((display_type IS NOT NULL) OR is_downpayment OR ((product_id IS NOT NULL) AND (product_uom IS NOT NULL) AND (date_planned IS NOT NULL))),
	constraint purchase_order_line_non_accountable_null_fields
		check ((display_type IS NULL) OR ((product_id IS NULL) AND (price_unit = (0)::numeric) AND (product_uom_qty = (0)::double precision) AND (product_uom IS NULL) AND (date_planned IS NULL)))
);

comment on table purchase_order_line is 'Purchase Order Line';

comment on column purchase_order_line.product_uom is 'Unit of Measure';

comment on column purchase_order_line.product_id is 'Product';

comment on column purchase_order_line.order_id is 'Order Reference';

comment on column purchase_order_line.company_id is 'Company';

comment on column purchase_order_line.partner_id is 'Partner';

comment on column purchase_order_line.currency_id is 'Currency';

comment on column purchase_order_line.product_packaging_id is 'Packaging';

comment on column purchase_order_line.create_uid is 'Created by';

comment on column purchase_order_line.write_uid is 'Last Updated by';

comment on column purchase_order_line.state is 'Status';

comment on column purchase_order_line.qty_received_method is 'Received Qty Method';

comment on column purchase_order_line.display_type is 'Display Type';

comment on column purchase_order_line.analytic_distribution is 'Analytic Distribution';

comment on column purchase_order_line.name is 'Description';

comment on column purchase_order_line.product_qty is 'Quantity';

comment on column purchase_order_line.discount is 'Discount (%)';

comment on column purchase_order_line.price_unit is 'Unit Price';

comment on column purchase_order_line.price_subtotal is 'Subtotal';

comment on column purchase_order_line.price_total is 'Total';

comment on column purchase_order_line.qty_invoiced is 'Billed Qty';

comment on column purchase_order_line.qty_received is 'Received Qty';

comment on column purchase_order_line.qty_received_manual is 'Manual Received Qty';

comment on column purchase_order_line.qty_to_invoice is 'To Invoice Quantity';

comment on column purchase_order_line.is_downpayment is 'Is Downpayment';

comment on column purchase_order_line.date_planned is 'Expected Arrival';

comment on column purchase_order_line.create_date is 'Created on';

comment on column purchase_order_line.write_date is 'Last Updated on';

comment on column purchase_order_line.product_uom_qty is 'Total Quantity';

comment on column purchase_order_line.price_tax is 'Tax';

comment on column purchase_order_line.product_packaging_qty is 'Packaging Quantity';

comment on constraint purchase_order_line_accountable_required_fields on purchase_order_line is 'CHECK(display_type IS NOT NULL OR is_downpayment OR (product_id IS NOT NULL AND product_uom IS NOT NULL AND date_planned IS NOT NULL))';

comment on constraint purchase_order_line_non_accountable_null_fields on purchase_order_line is 'CHECK(display_type IS NULL OR (product_id IS NULL AND price_unit = 0 AND product_uom_qty = 0 AND product_uom IS NULL AND date_planned is NULL))';


drop table if exists payment_transaction;
create table payment_transaction
(
    id                    uuid,
    provider_id           uuid not null,
    company_id            uuid,
    payment_method_id     uuid not null,
    currency_id           uuid not null,
    token_id              uuid,
    source_transaction_id uuid,
    partner_id            uuid not null,
    partner_state_id      uuid,
    partner_country_id    uuid,
    create_uid            uuid,
    write_uid             uuid,
    reference             varchar not null,
    provider_reference    varchar,
    state                 varchar not null,
    operation             varchar,
    landing_route         varchar,
    partner_name          varchar,
    partner_lang          varchar,
    partner_email         varchar,
    partner_address       varchar,
    partner_zip           varchar,
    partner_city          varchar,
    partner_phone         varchar,
    state_message         text,
    amount                numeric not null,
    is_post_processed     boolean,
    tokenize              boolean,
    last_state_change     timestamp,
    create_date           timestamp,
    write_date            timestamp,
    payment_id            uuid,
    primary key (id),
    constraint payment_transaction_reference_uniq
        unique (reference),
    foreign key (provider_id) references payment_provider
        on delete restrict,
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (payment_method_id) references payment_method
        on delete restrict,
    foreign key (currency_id) references res_currency
        on delete restrict,
    foreign key (token_id) references payment_token
        on delete restrict,
    foreign key (source_transaction_id) references payment_transaction
        on delete set null,
    foreign key (partner_id) references res_partner
        on delete restrict,
    foreign key (partner_state_id) references res_country_state
        on delete set null,
--     foreign key (partner_country_id) references res_country
--         on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
--     foreign key (payment_id) references account_payment
--         on delete set null
);

comment on table payment_transaction is 'Payment Transaction';

comment on column payment_transaction.provider_id is 'Provider';

comment on column payment_transaction.company_id is 'Company';

comment on column payment_transaction.payment_method_id is 'Payment Method';

comment on column payment_transaction.currency_id is 'Currency';

comment on column payment_transaction.token_id is 'Payment Token';

comment on column payment_transaction.source_transaction_id is 'Source Transaction';

comment on column payment_transaction.partner_id is 'Customer';

comment on column payment_transaction.partner_state_id is 'State';

comment on column payment_transaction.partner_country_id is 'Country';

comment on column payment_transaction.create_uid is 'Created by';

comment on column payment_transaction.write_uid is 'Last Updated by';

comment on column payment_transaction.reference is 'Reference';

comment on column payment_transaction.provider_reference is 'Provider Reference';

comment on column payment_transaction.state is 'Status';

comment on column payment_transaction.operation is 'Operation';

comment on column payment_transaction.landing_route is 'Landing Route';

comment on column payment_transaction.partner_name is 'Partner Name';

comment on column payment_transaction.partner_lang is 'Language';

comment on column payment_transaction.partner_email is 'Email';

comment on column payment_transaction.partner_address is 'Address';

comment on column payment_transaction.partner_zip is 'Zip';

comment on column payment_transaction.partner_city is 'City';

comment on column payment_transaction.partner_phone is 'Phone';

comment on column payment_transaction.state_message is 'Message';

comment on column payment_transaction.amount is 'Amount';

comment on column payment_transaction.is_post_processed is 'Is Post-processed';

comment on column payment_transaction.tokenize is 'Create Token';

comment on column payment_transaction.last_state_change is 'Last State Change Date';

comment on column payment_transaction.create_date is 'Created on';

comment on column payment_transaction.write_date is 'Last Updated on';

comment on column payment_transaction.payment_id is 'Payment';

comment on constraint payment_transaction_reference_uniq on payment_transaction is 'unique(reference)';




drop table if exists account_payment;
create table account_payment
(
    id                                  uuid,
    message_main_attachment_id          uuid,
    move_id                             uuid,
    journal_id                          uuid not null,
    company_id                          uuid not null,
    partner_bank_id                     uuid,
    paired_internal_transfer_payment_id uuid,
    payment_method_line_id              uuid,
    payment_method_id                   uuid,
    currency_id                         uuid,
    partner_id                          uuid,
    outstanding_account_id              uuid,
    destination_account_id              uuid,
    create_uid                          uuid,
    write_uid                           uuid,
    name                                varchar,
    state                               varchar not null,
    payment_type                        varchar not null,
    partner_type                        varchar not null,
    memo                                varchar,
    payment_reference                   varchar,
    date                                date    not null,
    amount                              numeric,
    amount_company_currency_signed      numeric,
    is_reconciled                       boolean,
    is_matched                          boolean,
    is_sent                             boolean,
    create_date                         timestamp,
    write_date                          timestamp,
    payment_transaction_id              uuid,
    payment_token_id                    uuid,
    source_payment_id                   uuid,
    primary key (id),
    foreign key (message_main_attachment_id) references ir_attachment
        on delete set null,
--     foreign key (move_id) references account_move
--         on delete set null,
    foreign key (journal_id) references account_journal
        on delete restrict,
--     foreign key (company_id) references res_company
--         on delete restrict,
    foreign key (partner_bank_id) references res_partner_bank
        on delete restrict,
    foreign key (paired_internal_transfer_payment_id) references account_payment
        on delete set null,
    foreign key (payment_method_line_id) references account_payment_method_line
        on delete set null,
    foreign key (payment_method_id) references account_payment_method
        on delete set null,
    foreign key (currency_id) references res_currency
        on delete set null,
    foreign key (partner_id) references res_partner
        on delete restrict,
    foreign key (outstanding_account_id) references account_account
        on delete set null,
    foreign key (destination_account_id) references account_account
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null,
    foreign key (payment_transaction_id) references payment_transaction
        on delete set null,
    foreign key (payment_token_id) references payment_token
        on delete set null,
    foreign key (source_payment_id) references account_payment
        on delete set null,
    constraint account_payment_check_amount_not_negative
        check (amount >= 0.0)
);

comment on table account_payment is 'Payments';

comment on column account_payment.message_main_attachment_id is 'Main Attachment';

comment on column account_payment.move_id is 'Journal Entry';

comment on column account_payment.journal_id is 'Journal';

comment on column account_payment.company_id is 'Company';

comment on column account_payment.partner_bank_id is 'Recipient Bank Account';

comment on column account_payment.paired_internal_transfer_payment_id is 'Paired Internal Transfer Payment';

comment on column account_payment.payment_method_line_id is 'Payment Method';

comment on column account_payment.payment_method_id is 'Method';

comment on column account_payment.currency_id is 'Currency';

comment on column account_payment.partner_id is 'Customer/Vendor';

comment on column account_payment.outstanding_account_id is 'Outstanding Account';

comment on column account_payment.destination_account_id is 'Destination Account';

comment on column account_payment.create_uid is 'Created by';

comment on column account_payment.write_uid is 'Last Updated by';

comment on column account_payment.name is 'Number';

comment on column account_payment.state is 'State';

comment on column account_payment.payment_type is 'Payment Type';

comment on column account_payment.partner_type is 'Partner Type';

comment on column account_payment.memo is 'Memo';

comment on column account_payment.payment_reference is 'Payment Reference';

comment on column account_payment.date is 'Date';

comment on column account_payment.amount is 'Amount';

comment on column account_payment.amount_company_currency_signed is 'Amount Company Currency Signed';

comment on column account_payment.is_reconciled is 'Is Reconciled';

comment on column account_payment.is_matched is 'Is Matched With a Bank Statement';

comment on column account_payment.is_sent is 'Is Sent';

comment on column account_payment.create_date is 'Created on';

comment on column account_payment.write_date is 'Last Updated on';

comment on column account_payment.payment_transaction_id is 'Payment Transaction';

comment on column account_payment.payment_token_id is 'Saved Payment Token';

comment on column account_payment.source_payment_id is 'Source Payment';

comment on constraint account_payment_check_amount_not_negative on account_payment is 'CHECK(amount >= 0.0)';





drop table if exists account_bank_statement_line;
create table account_bank_statement_line
(
    id                  uuid,
    move_id             uuid not null,
    journal_id          uuid not null,
    company_id          uuid not null,
    statement_id        uuid,
    partner_id          uuid,
    currency_id         uuid,
    foreign_currency_id uuid,
    create_uid          uuid,
    write_uid           uuid,
    account_number      varchar,
    partner_name        varchar,
    transaction_type    varchar,
    payment_ref         varchar,
    internal_index      varchar,
    transaction_details jsonb,
    amount              numeric,
    amount_currency     numeric,
    is_reconciled       boolean,
    create_date         timestamp,
    write_date          timestamp,
    amount_residual     double precision,
    primary key (id),
--     foreign key (move_id) references account_move
--         on delete cascade,
    foreign key (journal_id) references account_journal
        on delete set null,
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (statement_id) references account_bank_statement
        on delete set null,
    foreign key (partner_id) references res_partner
        on delete restrict,
    foreign key (currency_id) references res_currency
        on delete set null,
    foreign key (foreign_currency_id) references res_currency
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_bank_statement_line is 'Bank Statement Line';

comment on column account_bank_statement_line.move_id is 'Journal Entry';

comment on column account_bank_statement_line.journal_id is 'Journal';

comment on column account_bank_statement_line.company_id is 'Company';

comment on column account_bank_statement_line.statement_id is 'Statement';

comment on column account_bank_statement_line.partner_id is 'Partner';

comment on column account_bank_statement_line.currency_id is 'Journal Currency';

comment on column account_bank_statement_line.foreign_currency_id is 'Foreign Currency';

comment on column account_bank_statement_line.create_uid is 'Created by';

comment on column account_bank_statement_line.write_uid is 'Last Updated by';

comment on column account_bank_statement_line.account_number is 'Bank Account Number';

comment on column account_bank_statement_line.partner_name is 'Partner Name';

comment on column account_bank_statement_line.transaction_type is 'Transaction Type';

comment on column account_bank_statement_line.payment_ref is 'Label';

comment on column account_bank_statement_line.internal_index is 'Internal Reference';

comment on column account_bank_statement_line.transaction_details is 'Transaction Details';

comment on column account_bank_statement_line.amount is 'Amount';

comment on column account_bank_statement_line.amount_currency is 'Amount in Currency';

comment on column account_bank_statement_line.is_reconciled is 'Is Reconciled';

comment on column account_bank_statement_line.create_date is 'Created on';

comment on column account_bank_statement_line.write_date is 'Last Updated on';

comment on column account_bank_statement_line.amount_residual is 'Residual Amount';


drop table if exists  account_cash_rounding;
create table account_cash_rounding
(
	id uuid,
	create_uid uuid,
	write_uid uuid,
	strategy varchar not null,
	rounding_method varchar not null,
	name jsonb not null,
	profit_account_id jsonb,
	loss_account_id jsonb,
	create_date timestamp,
	write_date timestamp,
	rounding double precision not null,
	primary key (id),
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table account_cash_rounding is 'Account Cash Rounding';

comment on column account_cash_rounding.create_uid is 'Created by';

comment on column account_cash_rounding.write_uid is 'Last Updated by';

comment on column account_cash_rounding.strategy is 'Rounding Strategy';

comment on column account_cash_rounding.rounding_method is 'Rounding Method';

comment on column account_cash_rounding.name is 'Name';

comment on column account_cash_rounding.profit_account_id is 'Profit Account';

comment on column account_cash_rounding.loss_account_id is 'Loss Account';

comment on column account_cash_rounding.create_date is 'Created on';

comment on column account_cash_rounding.write_date is 'Last Updated on';

comment on column account_cash_rounding.rounding is 'Rounding Precision';


drop table if exists account_move;
create table account_move
(
    id                                uuid primary key,

    message_main_attachment_id        uuid    references ir_attachment
                                                  on delete set null,
    journal_id                        uuid    not null references account_journal
        on delete restrict,
    company_id                        uuid,
    origin_payment_id                 uuid
                                              references account_payment
                                                  on delete set null,
    statement_line_id                 uuid
                                              references account_bank_statement_line
                                                  on delete set null,
    tax_cash_basis_rec_id             uuid,
    tax_cash_basis_origin_move_id     uuid
                                              references account_move
                                                  on delete set null,
    auto_post_origin_id               uuid
                                              references account_move
                                                  on delete set null,
    secure_sequence_number            uuid,
    invoice_payment_term_id           uuid
                                              references account_payment_term
                                                  on delete set null,
    partner_id                        uuid
        references res_partner
            on delete restrict,
    commercial_partner_id             uuid
        references res_partner
            on delete restrict,
    partner_shipping_id               uuid
                                              references res_partner
                                                  on delete set null,
    partner_bank_id                   uuid
        references res_partner_bank
            on delete restrict,
    fiscal_position_id                uuid
        references account_fiscal_position
            on delete restrict,
    preferred_payment_method_line_id  uuid
                                              references account_payment_method_line
                                                  on delete set null,
    currency_id                       uuid    not null
        references res_currency
            on delete restrict,
    reversed_entry_id                 uuid
                                              references account_move
                                                  on delete set null,
    invoice_user_id                   uuid
                                              references res_users
                                                  on delete set null,
    invoice_incoterm_id               uuid
                                              references account_incoterms
                                                  on delete set null,
    invoice_cash_rounding_id          uuid
                                              references account_cash_rounding
                                                  on delete set null,
    create_uid                        uuid
                                              references res_users
                                                  on delete set null,
    write_uid                         uuid
                                              references res_users
                                                  on delete set null,
    sequence_prefix                   varchar,
    access_token                      varchar,
    name                              varchar,
    ref                               varchar,
    state                             varchar not null,
    move_type                         varchar not null,
    auto_post                         varchar not null,
    inalterable_hash                  varchar,
    payment_reference                 varchar,
    qr_code_method                    varchar,
    payment_state                     varchar,
    invoice_source_email              varchar,
    invoice_partner_display_name      varchar,
    invoice_origin                    varchar,
    incoterm_location                 varchar,
    date                              date    not null,
    auto_post_until                   date,
    invoice_date                      date,
    invoice_date_due                  date,
    delivery_date                     date,
    sending_data                      jsonb,
    narration                         text,
    invoice_currency_rate             numeric,
    amount_untaxed                    numeric,
    amount_tax                        numeric,
    amount_total                      numeric,
    amount_residual                   numeric,
    amount_untaxed_signed             numeric,
    amount_untaxed_in_currency_signed numeric,
    amount_tax_signed                 numeric,
    amount_total_signed               numeric,
    amount_total_in_currency_signed   numeric,
    amount_residual_signed            numeric,
    quick_edit_total_amount           numeric,
    is_storno                         boolean,
    always_tax_exigible               boolean,
    checked                           boolean,
    posted_before                     boolean,
    made_sequence_gap                 boolean,
    is_manually_modified              boolean,
    is_move_sent                      boolean,
    create_date                       timestamp,
    write_date                        timestamp
);

comment on table account_move is 'Journal Entry';

comment on column account_move.message_main_attachment_id is 'Main Attachment';

comment on column account_move.journal_id is 'Journal';

comment on column account_move.company_id is 'Company';

comment on column account_move.origin_payment_id is 'Payment';

comment on column account_move.statement_line_id is 'Statement Line';

comment on column account_move.tax_cash_basis_rec_id is 'Tax Cash Basis Entry of';

comment on column account_move.tax_cash_basis_origin_move_id is 'Cash Basis Origin';

comment on column account_move.auto_post_origin_id is 'First recurring entry';

comment on column account_move.secure_sequence_number is 'Inalterability No Gap Sequence #';

comment on column account_move.invoice_payment_term_id is 'Payment Terms';

comment on column account_move.partner_id is 'Partner';

comment on column account_move.commercial_partner_id is 'Commercial Entity';

comment on column account_move.partner_shipping_id is 'Delivery Address';

comment on column account_move.partner_bank_id is 'Recipient Bank';

comment on column account_move.fiscal_position_id is 'Fiscal Position';

comment on column account_move.preferred_payment_method_line_id is 'Preferred Payment Method Line';

comment on column account_move.currency_id is 'Currency';

comment on column account_move.reversed_entry_id is 'Reversal of';

comment on column account_move.invoice_user_id is 'Salesperson';

comment on column account_move.invoice_incoterm_id is 'Incoterm';

comment on column account_move.invoice_cash_rounding_id is 'Cash Rounding Method';

comment on column account_move.create_uid is 'Created by';

comment on column account_move.write_uid is 'Last Updated by';

comment on column account_move.sequence_prefix is 'Sequence Prefix';

comment on column account_move.access_token is 'Security Token';

comment on column account_move.name is 'Number';

comment on column account_move.ref is 'Reference';

comment on column account_move.state is 'Status';

comment on column account_move.move_type is 'Type';

comment on column account_move.auto_post is 'Auto-post';

comment on column account_move.inalterable_hash is 'Inalterability Hash';

comment on column account_move.payment_reference is 'Payment Reference';

comment on column account_move.qr_code_method is 'Payment QR-code';

comment on column account_move.payment_state is 'Payment Status';

comment on column account_move.invoice_source_email is 'Source Email';

comment on column account_move.invoice_partner_display_name is 'Invoice Partner Display Name';

comment on column account_move.invoice_origin is 'Origin';

comment on column account_move.incoterm_location is 'Incoterm Location';

comment on column account_move.date is 'Date';

comment on column account_move.auto_post_until is 'Auto-post until';

comment on column account_move.invoice_date is 'Invoice/Bill Date';

comment on column account_move.invoice_date_due is 'Due Date';

comment on column account_move.delivery_date is 'Delivery Date';

comment on column account_move.sending_data is 'Sending Data';

comment on column account_move.narration is 'Terms and Conditions';

comment on column account_move.invoice_currency_rate is 'Currency Rate';

comment on column account_move.amount_untaxed is 'Untaxed Amount';

comment on column account_move.amount_tax is 'Tax';

comment on column account_move.amount_total is 'Total';

comment on column account_move.amount_residual is 'Amount Due';

comment on column account_move.amount_untaxed_signed is 'Untaxed Amount Signed';

comment on column account_move.amount_untaxed_in_currency_signed is 'Untaxed Amount Signed Currency';

comment on column account_move.amount_tax_signed is 'Tax Signed';

comment on column account_move.amount_total_signed is 'Total Signed';

comment on column account_move.amount_total_in_currency_signed is 'Total in Currency Signed';

comment on column account_move.amount_residual_signed is 'Amount Due Signed';

comment on column account_move.quick_edit_total_amount is 'Total (Tax inc.)';

comment on column account_move.is_storno is 'Is Storno';

comment on column account_move.always_tax_exigible is 'Always Tax Exigible';

comment on column account_move.checked is 'Checked';

comment on column account_move.posted_before is 'Posted Before';

comment on column account_move.made_sequence_gap is 'Made Sequence Gap';

comment on column account_move.is_manually_modified is 'Is Manually Modified';

comment on column account_move.is_move_sent is 'Is Move Sent';

comment on column account_move.create_date is 'Created on';

comment on column account_move.write_date is 'Last Updated on';



drop table if exists  account_full_reconcile;
create table account_full_reconcile
(
	id uuid,
	exchange_move_id uuid,
	create_uid uuid,
	write_uid uuid,
	create_date timestamp,
	write_date timestamp,
	primary key (id),
	foreign key (exchange_move_id) references account_move
		on delete set null,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table account_full_reconcile is 'Full Reconcile';

comment on column account_full_reconcile.exchange_move_id is 'Exchange Move';

comment on column account_full_reconcile.create_uid is 'Created by';

comment on column account_full_reconcile.write_uid is 'Last Updated by';

comment on column account_full_reconcile.create_date is 'Created on';

comment on column account_full_reconcile.write_date is 'Last Updated on';




drop table if exists account_move_line;
create table account_move_line
(
    id                       uuid,
    move_id                  uuid not null,
    journal_id               uuid,
    company_id               uuid,
    company_currency_id      uuid,
    account_id               uuid,
    currency_id              uuid not null,
    partner_id               uuid,
    reconcile_model_id       uuid,
    payment_id               uuid,
    statement_line_id        uuid,
    statement_id             uuid,
    group_tax_id             uuid,
    tax_line_id              uuid,
    tax_group_id             uuid,
    tax_repartition_line_id  uuid,
    full_reconcile_id        uuid,
    product_id               uuid,
    product_uom_id           uuid,
    create_uid               uuid,
    write_uid                uuid,
    move_name                varchar,
    parent_state             varchar,
    ref                      varchar,
    name                     varchar,
    matching_number          varchar,
    display_type             varchar not null,
    date                     date,
    invoice_date             date,
    date_maturity            date,
    discount_date            date,
    analytic_distribution    jsonb,
    debit                    numeric,
    credit                   numeric,
    balance                  numeric,
    amount_currency          numeric,
    tax_base_amount          numeric,
    amount_residual          numeric,
    amount_residual_currency numeric,
    quantity                 numeric,
    price_unit               numeric,
    price_subtotal           numeric,
    price_total              numeric,
    discount                 numeric,
    discount_amount_currency numeric,
    discount_balance         numeric,
    is_imported              boolean,
    tax_tag_invert           boolean,
    reconciled               boolean,
    create_date              timestamp,
    write_date               timestamp,
    purchase_line_id         uuid,
    is_downpayment           boolean,
    primary key (id),
    foreign key (move_id) references account_move
        on delete cascade,
    foreign key (journal_id) references account_journal
        on delete set null,
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (company_currency_id) references res_currency
        on delete set null,
    foreign key (account_id) references account_account
        on delete cascade,
    foreign key (currency_id) references res_currency
        on delete restrict,
    foreign key (partner_id) references res_partner
        on delete restrict,
    foreign key (reconcile_model_id) references account_reconcile_model
        on delete set null,
    foreign key (payment_id) references account_payment
        on delete set null,
    foreign key (statement_line_id) references account_bank_statement_line
        on delete set null,
    foreign key (statement_id) references account_bank_statement
        on delete set null,
    foreign key (group_tax_id) references account_tax
        on delete set null,
    foreign key (tax_line_id) references account_tax
        on delete restrict,
    foreign key (tax_group_id) references account_tax_group
        on delete set null,
    foreign key (tax_repartition_line_id) references account_tax_repartition_line
        on delete restrict,
    foreign key (full_reconcile_id) references account_full_reconcile
        on delete set null,
    foreign key (product_id) references product_product
        on delete restrict,
    foreign key (product_uom_id) references uom_uom
        on delete restrict,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null,
    foreign key (purchase_line_id) references purchase_order_line
        on delete set null,
    constraint account_move_line_check_credit_debit
        check (((display_type)::text = ANY
                ((ARRAY ['line_section'::character varying, 'line_note'::character varying])::text[])) OR
               ((credit * debit) = (0)::numeric)),
    constraint account_move_line_check_amount_currency_balance_sign
        check (((display_type)::text = ANY
                ((ARRAY ['line_section'::character varying, 'line_note'::character varying])::text[])) OR
               (((balance <= (0)::numeric) AND (amount_currency <= (0)::numeric)) OR
                ((balance >= (0)::numeric) AND (amount_currency >= (0)::numeric)))),
    constraint account_move_line_check_accountable_required_fields
        check (((display_type)::text = ANY
                ((ARRAY ['line_section'::character varying, 'line_note'::character varying])::text[])) OR
               (account_id IS NOT NULL)),
    constraint account_move_line_check_non_accountable_fields_null
        check (((display_type)::text <> ALL
                ((ARRAY ['line_section'::character varying, 'line_note'::character varying])::text[])) OR
               ((amount_currency = (0)::numeric) AND (debit = (0)::numeric) AND (credit = (0)::numeric) AND
                (account_id IS NULL)))
);

comment on table account_move_line is 'Journal Item';

comment on column account_move_line.move_id is 'Journal Entry';

comment on column account_move_line.journal_id is 'Journal';

comment on column account_move_line.company_id is 'Company';

comment on column account_move_line.company_currency_id is 'Company Currency';

comment on column account_move_line.account_id is 'Account';

comment on column account_move_line.currency_id is 'Currency';

comment on column account_move_line.partner_id is 'Partner';

comment on column account_move_line.reconcile_model_id is 'Reconciliation Model';

comment on column account_move_line.payment_id is 'Originator Payment';

comment on column account_move_line.statement_line_id is 'Originator Statement Line';

comment on column account_move_line.statement_id is 'Statement';

comment on column account_move_line.group_tax_id is 'Originator Group of Taxes';

comment on column account_move_line.tax_line_id is 'Originator Tax';

comment on column account_move_line.tax_group_id is 'Originator tax group';

comment on column account_move_line.tax_repartition_line_id is 'Originator Tax Distribution Line';

comment on column account_move_line.full_reconcile_id is 'Matching';

comment on column account_move_line.product_id is 'Product';

comment on column account_move_line.product_uom_id is 'Unit of Measure';

comment on column account_move_line.create_uid is 'Created by';

comment on column account_move_line.write_uid is 'Last Updated by';

comment on column account_move_line.move_name is 'Number';

comment on column account_move_line.parent_state is 'Status';

comment on column account_move_line.ref is 'Reference';

comment on column account_move_line.name is 'Label';

comment on column account_move_line.matching_number is 'Matching #';

comment on column account_move_line.display_type is 'Display Type';

comment on column account_move_line.date is 'Date';

comment on column account_move_line.invoice_date is 'Invoice/Bill Date';

comment on column account_move_line.date_maturity is 'Due Date';

comment on column account_move_line.discount_date is 'Discount Date';

comment on column account_move_line.analytic_distribution is 'Analytic Distribution';

comment on column account_move_line.debit is 'Debit';

comment on column account_move_line.credit is 'Credit';

comment on column account_move_line.balance is 'Balance';

comment on column account_move_line.amount_currency is 'Amount in Currency';

comment on column account_move_line.tax_base_amount is 'Base Amount';

comment on column account_move_line.amount_residual is 'Residual Amount';

comment on column account_move_line.amount_residual_currency is 'Residual Amount in Currency';

comment on column account_move_line.quantity is 'Quantity';

comment on column account_move_line.price_unit is 'Unit Price';

comment on column account_move_line.price_subtotal is 'Subtotal';

comment on column account_move_line.price_total is 'Total';

comment on column account_move_line.discount is 'Discount (%)';

comment on column account_move_line.discount_amount_currency is 'Discount amount in Currency';

comment on column account_move_line.discount_balance is 'Discount Balance';

comment on column account_move_line.is_imported is 'Is Imported';

comment on column account_move_line.tax_tag_invert is 'Invert Tags';

comment on column account_move_line.reconciled is 'Reconciled';

comment on column account_move_line.create_date is 'Created on';

comment on column account_move_line.write_date is 'Last Updated on';

comment on column account_move_line.purchase_line_id is 'Purchase Order Line';

comment on column account_move_line.is_downpayment is 'Is Downpayment';

comment on constraint account_move_line_check_credit_debit on account_move_line is 'CHECK(display_type IN (''line_section'', ''line_note'') OR credit * debit=0)';

comment on constraint account_move_line_check_amount_currency_balance_sign on account_move_line is 'CHECK(
                display_type IN (''line_section'', ''line_note'')
                OR (
                    (balance <= 0 AND amount_currency <= 0)
                    OR
                    (balance >= 0 AND amount_currency >= 0)
                )
            )';

comment on constraint account_move_line_check_accountable_required_fields on account_move_line is 'CHECK(display_type IN (''line_section'', ''line_note'') OR account_id IS NOT NULL)';

comment on constraint account_move_line_check_non_accountable_fields_null on account_move_line is 'CHECK(display_type NOT IN (''line_section'', ''line_note'') OR (amount_currency = 0 AND debit = 0 AND credit = 0 AND account_id IS NULL))';




drop table if exists account_partial_reconcile;
create table account_partial_reconcile
(
    id                     uuid,
    debit_move_id          uuid not null,
    credit_move_id         uuid not null,
    full_reconcile_id      uuid,
    exchange_move_id       uuid,
    debit_currency_id      uuid,
    credit_currency_id     uuid,
    company_id             uuid,
    create_uid             uuid,
    write_uid              uuid,
    max_date               date,
    amount                 numeric,
    debit_amount_currency  numeric,
    credit_amount_currency numeric,
    create_date            timestamp,
    write_date             timestamp,
    primary key (id),
    foreign key (debit_move_id) references account_move_line
        on delete restrict,
    foreign key (credit_move_id) references account_move_line
        on delete restrict,
    foreign key (full_reconcile_id) references account_full_reconcile
        on delete set null,
    foreign key (exchange_move_id) references account_move
        on delete set null,
    foreign key (debit_currency_id) references res_currency
        on delete set null,
    foreign key (credit_currency_id) references res_currency
        on delete set null,
--     foreign key (company_id) references res_company
--         on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null
);

comment on table account_partial_reconcile is 'Partial Reconcile';

comment on column account_partial_reconcile.debit_move_id is 'Debit Move';

comment on column account_partial_reconcile.credit_move_id is 'Credit Move';

comment on column account_partial_reconcile.full_reconcile_id is 'Full Reconcile';

comment on column account_partial_reconcile.exchange_move_id is 'Exchange Move';

comment on column account_partial_reconcile.debit_currency_id is 'Currency of the debit journal item.';

comment on column account_partial_reconcile.credit_currency_id is 'Currency of the credit journal item.';

comment on column account_partial_reconcile.company_id is 'Company';

comment on column account_partial_reconcile.create_uid is 'Created by';

comment on column account_partial_reconcile.write_uid is 'Last Updated by';

comment on column account_partial_reconcile.max_date is 'Max Date of Matched Lines';

comment on column account_partial_reconcile.amount is 'Amount';

comment on column account_partial_reconcile.debit_amount_currency is 'Debit Amount Currency';

comment on column account_partial_reconcile.credit_amount_currency is 'Credit Amount Currency';

comment on column account_partial_reconcile.create_date is 'Created on';

comment on column account_partial_reconcile.write_date is 'Last Updated on';



drop table if exists account_analytic_plan;
create table account_analytic_plan
(
	id uuid,
	parent_id uuid,
	color integer,
	create_uid uuid,
	write_uid uuid,
	parent_path varchar,
	complete_name varchar,
	name jsonb not null,
	default_applicability jsonb,
	description text,
	create_date timestamp,
	write_date timestamp,
	primary key (id),
	foreign key (parent_id) references account_analytic_plan
		on delete cascade,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table account_analytic_plan is 'Analytic Plans';

comment on column account_analytic_plan.parent_id is 'Parent';

comment on column account_analytic_plan.color is 'Color';

comment on column account_analytic_plan.create_uid is 'Created by';

comment on column account_analytic_plan.write_uid is 'Last Updated by';

comment on column account_analytic_plan.parent_path is 'Parent Path';

comment on column account_analytic_plan.complete_name is 'Complete Name';

comment on column account_analytic_plan.name is 'Name';

comment on column account_analytic_plan.default_applicability is 'Default Applicability';

comment on column account_analytic_plan.description is 'Description';

comment on column account_analytic_plan.create_date is 'Created on';

comment on column account_analytic_plan.write_date is 'Last Updated on';





drop table if exists account_analytic_account;
create table account_analytic_account
(
	id uuid,
	plan_id uuid not null,
	root_plan_id uuid,
	company_id uuid,
	partner_id uuid,
	create_uid uuid,
	write_uid uuid,
	code varchar,
	name jsonb not null,
	active boolean,
	create_date timestamp,
	write_date timestamp,
	primary key (id),
	foreign key (plan_id) references account_analytic_plan
		on delete restrict,
	foreign key (root_plan_id) references account_analytic_plan
		on delete set null,
-- 	foreign key (company_id) references res_company
-- 		on delete set null,
	foreign key (partner_id) references res_partner
		on delete set null,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null
);

comment on table account_analytic_account is 'Analytic Account';

comment on column account_analytic_account.plan_id is 'Plan';

comment on column account_analytic_account.root_plan_id is 'Root Plan';

comment on column account_analytic_account.company_id is 'Company';

comment on column account_analytic_account.partner_id is 'Customer';

comment on column account_analytic_account.create_uid is 'Created by';

comment on column account_analytic_account.write_uid is 'Last Updated by';

comment on column account_analytic_account.code is 'Reference';

comment on column account_analytic_account.name is 'Analytic Account';

comment on column account_analytic_account.active is 'Active';

comment on column account_analytic_account.create_date is 'Created on';

comment on column account_analytic_account.write_date is 'Last Updated on';




drop table if exists account_analytic_applicability;
create table account_analytic_applicability
(
	id uuid,
	analytic_plan_id uuid,
	company_id uuid,
	create_uid uuid,
	write_uid uuid,
	business_domain varchar not null,
	applicability varchar not null,
	create_date timestamp,
	write_date timestamp,
	product_categ_id uuid,
	account_prefix varchar,
	primary key (id),
	foreign key (analytic_plan_id) references account_analytic_plan
		on delete set null,
-- 	foreign key (company_id) references res_company
-- 		on delete set null,
	foreign key (create_uid) references res_users
		on delete set null,
	foreign key (write_uid) references res_users
		on delete set null,
	foreign key (product_categ_id) references product_category
		on delete set null
);

comment on table account_analytic_applicability is 'Analytic Plan''s Applicabilities';

comment on column account_analytic_applicability.analytic_plan_id is 'Analytic Plan';

comment on column account_analytic_applicability.company_id is 'Company';

comment on column account_analytic_applicability.create_uid is 'Created by';

comment on column account_analytic_applicability.write_uid is 'Last Updated by';

comment on column account_analytic_applicability.business_domain is 'Domain';

comment on column account_analytic_applicability.applicability is 'Applicability';

comment on column account_analytic_applicability.create_date is 'Created on';

comment on column account_analytic_applicability.write_date is 'Last Updated on';

comment on column account_analytic_applicability.product_categ_id is 'Product Category';

comment on column account_analytic_applicability.account_prefix is 'Financial Accounts Prefix';


-- todo: toi day
drop table if exists res_company;
create table res_company
(
    id                                                 uuid,
    name                                               varchar          not null,
    partner_id                                         uuid          not null,
    currency_id                                        uuid          not null,
    create_date                                        timestamp,
    parent_path                                        varchar,
    parent_id                                          uuid,
    paperformat_id                                     uuid,
    external_report_layout_id                          uuid,
    create_uid                                         uuid,
    write_uid                                          uuid,
    email                                              varchar,
    phone                                              varchar,
    mobile                                             varchar,
    font                                               varchar,
    primary_color                                      varchar,
    secondary_color                                    varchar,
    layout_background                                  varchar          not null,
    report_header                                      jsonb,
    report_footer                                      jsonb,
    company_details                                    jsonb,
    active                                             boolean,
    uses_default_logo                                  boolean,
    write_date                                         timestamp,
    logo_web                                           bytea,
    nomenclature_id                                    uuid,
    resource_calendar_id                               uuid,
    alias_domain_id                                    uuid,
    alias_domain_name                                  varchar,
    email_primary_color                                varchar,
    email_secondary_color                              varchar,
    partner_gid                                        uuid,
    iap_enrich_auto_done                               boolean,
    snailmail_color                                    boolean,
    snailmail_cover                                    boolean,
    snailmail_duplex                                   boolean,
    payment_onboarding_payment_method                  varchar,
    fiscalyear_last_day                                integer          not null,
    transfer_account_id                                uuid,
    default_cash_difference_income_account_id          uuid,
    default_cash_difference_expense_account_id         uuid,
    account_journal_suspense_account_id                uuid,
    account_journal_early_pay_discount_gain_account_id uuid,
    account_journal_early_pay_discount_loss_account_id uuid,
    account_sale_tax_id                                uuid,
    account_purchase_tax_id                            uuid,
    currency_exchange_journal_id                       uuid,
    income_currency_exchange_account_id                uuid,
    expense_currency_exchange_account_id               uuid,
    incoterm_id                                        uuid,
    account_opening_move_id                            uuid,
    account_default_pos_receivable_account_id          uuid,
    expense_accrual_account_id                         uuid,
    revenue_accrual_account_id                         uuid,
    automatic_entry_default_journal_id                 uuid,
    account_fiscal_country_id                          uuid,
    tax_cash_basis_journal_id                          uuid,
    account_cash_basis_base_account_id                 uuid,
    account_discount_income_allocation_id              uuid,
    account_discount_expense_allocation_id             uuid,
    fiscalyear_last_month                              varchar          not null,
    chart_template                                     varchar,
    bank_account_code_prefix                           varchar,
    cash_account_code_prefix                           varchar,
    transfer_account_code_prefix                       varchar,
    tax_calculation_rounding_method                    varchar,
    terms_type                                         varchar,
    quick_edit_mode                                    varchar,
    account_price_include                              varchar          not null,
    fiscalyear_lock_date                               date,
    tax_lock_date                                      date,
    sale_lock_date                                     date,
    purchase_lock_date                                 date,
    hard_lock_date                                     date,
    account_opening_date                               date             not null,
    invoice_terms                                      jsonb,
    invoice_terms_html                                 jsonb,
    expects_chart_of_accounts                          boolean,
    anglo_saxon_accounting                             boolean,
    qr_code                                            boolean,
    display_invoice_amount_total_words                 boolean,
    display_invoice_tax_company_currency               boolean,
    account_use_credit_limit                           boolean,
    tax_exigibility                                    boolean,
    account_storno                                     boolean,
    check_account_audit_trail                          boolean,
    autopost_bills                                     boolean,
    po_lock                                            varchar,
    po_double_validation                               varchar,
    po_double_validation_amount                        numeric,
    po_lead                                            double precision not null,
    primary key (id),
    constraint res_company_name_uniq
        unique (name),
    foreign key (parent_id) references res_company
        on delete restrict,
    foreign key (partner_id) references res_partner
        on delete restrict,
    foreign key (currency_id) references res_currency
        on delete restrict,
    foreign key (paperformat_id) references report_paperformat
        on delete set null,
    foreign key (external_report_layout_id) references ir_ui_view
        on delete set null,
    foreign key (create_uid) references res_users
        on delete set null,
    foreign key (write_uid) references res_users
        on delete set null,
    foreign key (nomenclature_id) references barcode_nomenclature
        on delete set null,
    foreign key (resource_calendar_id) references resource_calendar
        on delete restrict,
    foreign key (alias_domain_id) references mail_alias_domain
        on delete set null,
    foreign key (transfer_account_id) references account_account
        on delete set null,
    foreign key (default_cash_difference_income_account_id) references account_account
        on delete set null,
    foreign key (default_cash_difference_expense_account_id) references account_account
        on delete set null,
    foreign key (account_journal_suspense_account_id) references account_account
        on delete set null,
    constraint res_company_account_journal_early_pay_discount_gain_accoun_fkey
        foreign key (account_journal_early_pay_discount_gain_account_id) references account_account
            on delete set null,
    constraint res_company_account_journal_early_pay_discount_loss_accoun_fkey
        foreign key (account_journal_early_pay_discount_loss_account_id) references account_account
            on delete set null,
    foreign key (account_sale_tax_id) references account_tax
        on delete set null,
    foreign key (account_purchase_tax_id) references account_tax
        on delete set null,
    foreign key (currency_exchange_journal_id) references account_journal
        on delete set null,
    foreign key (income_currency_exchange_account_id) references account_account
        on delete set null,
    foreign key (expense_currency_exchange_account_id) references account_account
        on delete set null,
    foreign key (incoterm_id) references account_incoterms
        on delete set null,
    foreign key (account_opening_move_id) references account_move
        on delete set null,
    foreign key (account_default_pos_receivable_account_id) references account_account
        on delete set null,
    foreign key (expense_accrual_account_id) references account_account
        on delete set null,
    foreign key (revenue_accrual_account_id) references account_account
        on delete set null,
    foreign key (automatic_entry_default_journal_id) references account_journal
        on delete set null,
    foreign key (account_fiscal_country_id) references res_country
        on delete set null,
    foreign key (tax_cash_basis_journal_id) references account_journal
        on delete set null,
    foreign key (account_cash_basis_base_account_id) references account_account
        on delete set null,
    foreign key (account_discount_income_allocation_id) references account_account
        on delete set null,
    foreign key (account_discount_expense_allocation_id) references account_account
        on delete set null
);

comment on column res_company.parent_id is 'Parent Company';

comment on column res_company.paperformat_id is 'Paper format';

comment on column res_company.external_report_layout_id is 'Document Template';

comment on column res_company.create_uid is 'Created by';

comment on column res_company.write_uid is 'Last Updated by';

comment on column res_company.email is 'Email';

comment on column res_company.phone is 'Phone';

comment on column res_company.mobile is 'Mobile';

comment on column res_company.font is 'Font';

comment on column res_company.primary_color is 'Primary Color';

comment on column res_company.secondary_color is 'Secondary Color';

comment on column res_company.layout_background is 'Layout Background';

comment on column res_company.report_header is 'Company Tagline';

comment on column res_company.report_footer is 'Report Footer';

comment on column res_company.company_details is 'Company Details';

comment on column res_company.active is 'Active';

comment on column res_company.uses_default_logo is 'Uses Default Logo';

comment on column res_company.write_date is 'Last Updated on';

comment on column res_company.logo_web is 'Logo Web';

comment on column res_company.nomenclature_id is 'Nomenclature';

comment on column res_company.resource_calendar_id is 'Default Working Hours';

comment on column res_company.alias_domain_id is 'Email Domain';

comment on column res_company.alias_domain_name is 'Alias Domain Name';

comment on column res_company.email_primary_color is 'Email Header Color';

comment on column res_company.email_secondary_color is 'Email Button Color';

comment on column res_company.partner_gid is 'Company database ID';

comment on column res_company.iap_enrich_auto_done is 'Enrich Done';

comment on column res_company.snailmail_color is 'Snailmail Color';

comment on column res_company.snailmail_cover is 'Add a Cover Page';

comment on column res_company.snailmail_duplex is 'Both sides';

comment on column res_company.payment_onboarding_payment_method is 'Selected onboarding payment method';

comment on column res_company.fiscalyear_last_day is 'Fiscalyear Last Day';

comment on column res_company.transfer_account_id is 'Inter-Banks Transfer Account';

comment on column res_company.default_cash_difference_income_account_id is 'Cash Difference Income';

comment on column res_company.default_cash_difference_expense_account_id is 'Cash Difference Expense';

comment on column res_company.account_journal_suspense_account_id is 'Journal Suspense Account';

comment on column res_company.account_journal_early_pay_discount_gain_account_id is 'Cash Discount Write-Off Gain Account';

comment on column res_company.account_journal_early_pay_discount_loss_account_id is 'Cash Discount Write-Off Loss Account';

comment on column res_company.account_sale_tax_id is 'Default Sale Tax';

comment on column res_company.account_purchase_tax_id is 'Default Purchase Tax';

comment on column res_company.currency_exchange_journal_id is 'Exchange Gain or Loss Journal';

comment on column res_company.income_currency_exchange_account_id is 'Gain Exchange Rate Account';

comment on column res_company.expense_currency_exchange_account_id is 'Loss Exchange Rate Account';

comment on column res_company.incoterm_id is 'Default incoterm';

comment on column res_company.account_opening_move_id is 'Opening Journal Entry';

comment on column res_company.account_default_pos_receivable_account_id is 'Default PoS Receivable Account';

comment on column res_company.expense_accrual_account_id is 'Expense Accrual Account';

comment on column res_company.revenue_accrual_account_id is 'Revenue Accrual Account';

comment on column res_company.automatic_entry_default_journal_id is 'Automatic Entry Default Journal';

comment on column res_company.account_fiscal_country_id is 'Fiscal Country';

comment on column res_company.tax_cash_basis_journal_id is 'Cash Basis Journal';

comment on column res_company.account_cash_basis_base_account_id is 'Base Tax Received Account';

comment on column res_company.account_discount_income_allocation_id is 'Separate account for income discount';

comment on column res_company.account_discount_expense_allocation_id is 'Separate account for expense discount';

comment on column res_company.fiscalyear_last_month is 'Fiscalyear Last Month';

comment on column res_company.chart_template is 'Chart Template';

comment on column res_company.bank_account_code_prefix is 'Prefix of the bank accounts';

comment on column res_company.cash_account_code_prefix is 'Prefix of the cash accounts';

comment on column res_company.transfer_account_code_prefix is 'Prefix of the transfer accounts';

comment on column res_company.tax_calculation_rounding_method is 'Tax Calculation Rounding Method';

comment on column res_company.terms_type is 'Terms & Conditions format';

comment on column res_company.quick_edit_mode is 'Quick encoding';

comment on column res_company.account_price_include is 'Default Sales Price Include';

comment on column res_company.fiscalyear_lock_date is 'Global Lock Date';

comment on column res_company.tax_lock_date is 'Tax Return Lock Date';

comment on column res_company.sale_lock_date is 'Sales Lock Date';

comment on column res_company.purchase_lock_date is 'Purchase Lock date';

comment on column res_company.hard_lock_date is 'Hard Lock Date';

comment on column res_company.account_opening_date is 'Opening Entry';

comment on column res_company.invoice_terms is 'Default Terms and Conditions';

comment on column res_company.invoice_terms_html is 'Default Terms and Conditions as a Web page';

comment on column res_company.expects_chart_of_accounts is 'Expects a Chart of Accounts';

comment on column res_company.anglo_saxon_accounting is 'Use anglo-saxon accounting';

comment on column res_company.qr_code is 'Display QR-code on invoices';

comment on column res_company.display_invoice_amount_total_words is 'Total amount of invoice in letters';

comment on column res_company.display_invoice_tax_company_currency is 'Taxes in company currency';

comment on column res_company.account_use_credit_limit is 'Sales Credit Limit';

comment on column res_company.tax_exigibility is 'Use Cash Basis';

comment on column res_company.account_storno is 'Storno accounting';

comment on column res_company.check_account_audit_trail is 'Audit Trail';

comment on column res_company.autopost_bills is 'Auto-validate bills';

comment on column res_company.po_lock is 'Purchase Order Modification';

comment on column res_company.po_double_validation is 'Levels of Approvals';

comment on column res_company.po_double_validation_amount is 'Double validation amount';

comment on column res_company.po_lead is 'Purchase Lead Time';

comment on constraint res_company_name_uniq on res_company is 'unique (name)';
