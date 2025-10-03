SELECT
    p.pageid,
    p.moduleid,
    p.parentpageid,
    p.pagename,
    p.href,
    p.icon,
    p.description,
    p.istitle,
    p.position,
    p.active
FROM
    pages p
INNER JOIN roles_modules rm ON p.moduleid = rm.moduleid
INNER JOIN roles r ON rm.roleid = r.roleid
WHERE
		r.roleid IN (
			SELECT
				gr.roleid
			FROM
				groups
				G INNER JOIN groups_roles gr ON G.groupid = gr.groupid
				INNER JOIN user_groups ug ON G.groupid = ug.groupid
			WHERE
				G.organizationid = '23277553-adf7-4a9b-9cbe-23f055054353'
				AND ug.userid = '5cc18cc1-e527-4f12-8635-608d9d6bbb83'
    )
    OR r.roleid IN (
        SELECT
					ur.roleid
				FROM
					users_roles AS ur
					INNER JOIN users_orgs AS uo ON ur.userid = uo.userid
				WHERE
					uo.userid = '5cc18cc1-e527-4f12-8635-608d9d6bbb83'
					AND uo.organizationid = '23277553-adf7-4a9b-9cbe-23f055054353'
    )

