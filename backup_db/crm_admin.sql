create table public.actions
(
    actionid     uuid not null,
    actionname   varchar(20),
    resourceid   uuid not null,
    resourcename varchar(255),
    primary key (actionid, resourceid)
);

create table public.authorities
(
    authorityid   uuid not null
        primary key,
    authorityname varchar(75)
);

create table public.emails
(
    userid           uuid not null
        primary key,
    username         varchar(100),
    toemail          varchar(100),
    subject          varchar(255),
    message          varchar(1024),
    scheduledtime    date,
    zoneid           varchar,
    sentdate         date,
    errordescription varchar(255),
    status           integer
);

create table public.modules
(
    moduleid    uuid not null
        constraint module__pkey
            primary key,
    modulename  varchar(100),
    description varchar(255),
    position    integer,
    moduletype  integer,
    active      boolean
);

create table public.organizations
(
    organizationid       uuid not null
        constraint organization__pkey
            primary key,
    parentorganizationid uuid,
    organizationname     varchar(100),
    createdate           timestamp(6),
    modifieddate         timestamp(6),
    userupdate           varchar(100),
    active               boolean
);

create table public.pages
(
    pageid       uuid not null,
    moduleid     uuid not null,
    parentpageid uuid,
    pagename     varchar(100),
    href         varchar(255),
    icon         varchar(255),
    description  varchar(255),
    istitle      boolean,
    position     integer,
    active       boolean,
    constraint page__pkey
        primary key (pageid, moduleid)
);

create table public.permissions
(
    roleid     uuid not null,
    moduleid   uuid not null,
    pageid     uuid not null,
    actionid   uuid not null,
    isselected boolean,
    primary key (roleid, moduleid, pageid, actionid)
);

create table public.resetpasswordtoken
(
    userid     uuid        not null
        constraint resetpasswordtoken__pkey
            primary key,
    token      varchar(75) not null,
    expirydate timestamp(6)
);

create table public.rolemodulepage
(
    roleid     uuid not null,
    moduleid   uuid not null,
    pageid     uuid not null,
    isselected boolean,
    primary key (roleid, moduleid, pageid)
);

create table public.roles
(
    roleid         uuid not null
        constraint role__pkey
            primary key,
    organizationid uuid,
    rolename       varchar(100),
    description    varchar(255),
    roletype       integer,
    createdate     timestamp(6),
    modifieddate   timestamp(6),
    userupdate     varchar(100),
    active         boolean
);

create table public.roles_modules
(
    roleid   uuid not null,
    moduleid uuid not null,
    primary key (roleid, moduleid)
);

create table public.tokens
(
    tokenid uuid not null
        primary key,
    userid  uuid not null,
    token   varchar(255),
    revoked boolean,
    expired boolean
);

create table public.users
(
    userid               uuid        not null
        constraint user__pkey
            primary key,
    organizationid       uuid,
    username             varchar(50) not null,
    fullname             varchar(100),
    password             varchar(100),
    emailaddress         varchar(100),
    jobtitle             varchar(100),
    gender               integer,
    phonenumber          varchar(50),
    passwordencrypted    boolean,
    passwordreset        boolean,
    passwordmodifieddate timestamp(6),
    gracelogincount      integer,
    languageid           varchar(75),
    timezoneid           varchar(75),
    logindate            timestamp(6),
    loginip              varchar(75),
    lastlogindate        timestamp(6),
    lastloginip          varchar(75),
    lastfailedlogindate  timestamp(6),
    failedloginattempts  integer,
    lockout              boolean,
    lockoutdate          timestamp(6),
    usertype             integer,
    createdate           timestamp(6),
    modifieddate         timestamp(6),
    userupdate           varchar(100),
    status               integer
);

create table public.users_authorities
(
    userid      uuid not null,
    authorityid uuid not null,
    primary key (userid, authorityid)
);

create table public.users_orgs
(
    organizationid uuid not null,
    userid         uuid not null,
    primary key (organizationid, userid)
);

create table public.users_roles
(
    userid uuid not null,
    roleid uuid not null,
    primary key (userid, roleid)
);

