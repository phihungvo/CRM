package com.base.admin.constant;

public class MenuDefault {
    public static final String jsonMenu =
            """
			[
							{
							"pagename": "Home",
							"modulename": "Default",
							"istitle": true,
							"href": "/",
							"icon": "ri-home-line",
							"childMenu": []
							},
							{
							"pagename": "Applications",
							"modulename": "Applications",
							"istitle": true,
							"href": "",
							"icon": "ri-apps-line",
							"childMenu": [
								{
									"pagename": "HRM",
									"modulename": "HRM",
									"istitle": true,
									"href": "/apps/hrm",
									"icon": "",
									"childMenu": [
									{
										"pagename": "Overview",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/overview",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Lists",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/lists",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Contracts",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/contracts",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Designattions",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/designations",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Leaves Request",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/leaves",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Dismissions",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/dismissions",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Displacements",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/displacements",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Discontinues",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/discontinues",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Insentives",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/Insentives",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Incidences",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/incidences",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Benefits",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/benefits",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Plannings",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/plannings",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Proposes",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/proposes",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Reporting",
										"modulename": "HRM",
										"istitle": false,
										"href": "/apps/hrm/reporting",
										"icon": "",
										"childMenu": []
									},
									{
										"pagename": "Settings",
										"modulename": "HRM",
										"istitle": true,
										"href": "/apps/hrm/settings",
										"icon": "",
										"childMenu": [
											{
											"pagename": "Organization Structure",
												"modulename": "HRM",
												"istitle": false,
												"href": "/apps/hrm/settings/units",
												"icon": "",
												"childMenu": []
											},
											{
												"pagename": "Job Position",
												"modulename": "HRM",
												"istitle": false,
												"href": "/apps/hrm/settings/jobposition",
												"icon": "",
												"childMenu": []
											}
										]
									}
									]
								},
								{
								"pagename": "Inventory",
								"modulename": "Inventory",
								"istitle": true,
								"href": "/apps/inventory",
								"icon": "",
								"childMenu": [
									{
									"pagename": "Overview",
									"modulename": "Inventory",
									"istitle": false,
									"href": "/apps/inventory/overview",
									"icon": "",
									"childMenu": []
									},
									{
									"pagename": "Purchase",
									"modulename": "Inventory",
									"istitle": true,
									"href": "/apps/inventory/purchases",
									"icon": "",
									"childMenu": [
										{
										"pagename": "All Purchases",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/purchases",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Create Purchase",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/purchases/add",
										"icon": "",
										"childMenu": []
										}
									]
									},
									{
									"pagename": "Sales",
									"modulename": "Inventory",
									"istitle": true,
									"href": "/apps/inventory/sales",
									"icon": "",
									"childMenu": [
										{
										"pagename": "All Sales",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/sales",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Create Sale",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/sales/add",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Shipments",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/sales/shipments",
										"icon": "",
										"childMenu": []
										}
									]
									},
									{
									"pagename": "Quotations",
									"modulename": "Inventory",
									"istitle": true,
									"href": "/apps/inventory/quotations",
									"icon": "",
									"childMenu": [
										{
										"pagename": "All Quotations",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/quotations",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Create Quotation",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/quotations/add",
										"icon": "",
										"childMenu": []
										}
									]
									},
									{
									"pagename": "Adjustments",
									"modulename": "Inventory",
									"istitle": true,
									"href": "/apps/inventory/adjustments",
									"icon": "",
									"childMenu": [
										{
										"pagename": "All Adjustments",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/adjustments",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Create Adjustment",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/adjustments/add",
										"icon": "",
										"childMenu": []
										}
									]
									},
									{
									"pagename": "Transfers",
									"modulename": "Inventory",
									"istitle": true,
									"href": "/apps/inventory/transfers",
									"icon": "",
									"childMenu": [
										{
										"pagename": "All Transfers",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/transfers",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Create Transfers",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/transfers/add",
										"icon": "",
										"childMenu": []
										}
									]
									},
									{
									"pagename": "Purchases Return",
									"modulename": "Inventory",
									"istitle": false,
									"href": "/apps/inventory/purchases/returns",
									"icon": "",
									"childMenu": []
									},
									{
									"pagename": "Sales Return",
									"modulename": "Inventory",
									"istitle": false,
									"href": "/apps/inventory/sales/returns",
									"icon": "",
									"childMenu": []
									},
									{
									"pagename": "Configuration",
									"modulename": "Inventory",
									"istitle": true,
									"href": "/apps/inventory/configuration",
									"icon": "",
									"childMenu": [
										{
										"pagename": "Warehouses",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/configuration/warehouses",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Products",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/configuration/products",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Types",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/configuration/products/types",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Categories",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/configuration/products/categories",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Brands",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/configuration/products/brands",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Units of Measures",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/configuration/products/units",
										"icon": "",
										"childMenu": []
										}
									]
									},
									{
									"pagename": "Reporting",
									"modulename": "Inventory",
									"istitle": true,
									"href": "",
									"icon": "",
									"childMenu": [
										{
										"pagename": "Payments",
										"modulename": "Inventory",
										"istitle": true,
										"href": "/apps/inventory/reporting/payments",
										"icon": "",
										"childMenu": [
											{
											"pagename": "Purchase",
											"modulename": "Inventory",
											"istitle": false,
											"href": "/apps/inventory/reporting/payments/purchases",
											"icon": "",
											"childMenu": []
											},
											{
											"pagename": "Sales",
											"modulename": "Inventory",
											"istitle": false,
											"href": "/apps/inventory/reporting/payments/sales",
											"icon": "",
											"childMenu": []
											},
											{
											"pagename": "Sales Return",
											"modulename": "Inventory",
											"istitle": false,
											"href": "/apps/inventory/reporting/payments/salesreturn",
											"icon": "",
											"childMenu": []
											},
											{
											"pagename": "Purchase Return",
											"modulename": "Inventory",
											"istitle": false,
											"href": "/apps/inventory/reporting/payments/purchasereturn",
											"icon": "",
											"childMenu": []
											}
										]
										},
										{
										"pagename": "Profit and Lost",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/reporting/profitandlost",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Warehouse",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/reporting/warehouse",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Stock",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/reporting/stock",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Product",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/reporting/product",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Moves History",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/reporting/moves-history",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Stock Moves",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/reporting/stock-move",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Locations",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/reporting/locations",
										"icon": "",
										"childMenu": []
										},
										{
										"pagename": "Valuation",
										"modulename": "Inventory",
										"istitle": false,
										"href": "/apps/inventory/reporting/valuation",
										"icon": "",
										"childMenu": []
										}
									]
									}
								]
								}
							]
							},
							{
							"pagename": "General Settings",
							"modulename": "Admin",
							"istitle": true,
							"href": "/settings",
							"icon": "ri-user-settings-line",
							"childMenu": [
								{
								"pagename": "Users & Companies",
								"modulename": "Admin",
								"istitle": true,
								"href": "",
								"icon": "",
								"childMenu": [
									{
									"pagename": "Companies",
									"modulename": "Admin",
									"istitle": false,
									"href": "/settings/organizations",
									"icon": "",
									"childMenu": []
									},
									{
									"pagename": "Users",
									"modulename": "Admin",
									"istitle": false,
									"href": "/settings/users",
									"icon": "",
									"childMenu": []
									},
									{
									"pagename": "Roles",
									"modulename": "Admin",
									"istitle": false,
									"href": "/settings/roles",
									"icon": "",
									"childMenu": []
									},
									{
									"pagename": "Modules",
									"modulename": "Admin",
									"istitle": false,
									"href": "/settings/modules",
									"icon": "",
									"childMenu": []
									}
								]
								}
							]
							},
							{
							"pagename": "System Configuration",
							"modulename": "SuperAdmin",
							"istitle": true,
							"href": "/configuration",
							"icon": "ri-list-settings-line",
							"childMenu": [
								{
								"pagename": "Email",
								"modulename": "SuperAdmin",
								"istitle": true,
								"href": "/configuration/email",
								"icon": "",
								"childMenu": [
									{
									"pagename": "Emails",
									"modulename": "SuperAdmin",
									"istitle": false,
									"href": "/configuration/email/emmails",
									"icon": "",
									"childMenu": []
									}
								]
								}
							]
							}
						]
			""";
}
