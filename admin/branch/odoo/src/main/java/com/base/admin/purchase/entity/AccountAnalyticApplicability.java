package com.base.admin.purchase.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * account_account
 *
 * @author
 */
@Getter
@Setter
public class AccountAnalyticApplicability implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    /**
     * Account Currency
     */
    private UUID currencyId;
    /**
     * Created by
     */
    private UUID createUid;
    /**
     * Last Updated by
     */
    private UUID writeUid;
    /**
     * Type
     */
    private String accountType;
    /**
     * Account Name
     */
    private UUID name;
    /**
     * Code Store
     */
    private UUID codeStore;
    /**
     * Internal Notes
     */
    private String note;
    /**
     * Deprecated
     */
    private Boolean deprecated;
    /**
     * Allow Reconciliation
     */
    private Boolean reconcile;
    /**
     * Non Trade
     */
    private Boolean nonTrade;
    /**
     * Created on
     */
    private Date createDate;
    /**
     * Last Updated on
     */
    private Date writeDate;
}
