/*
 * This file is generated by jOOQ.
*/
package fi.istrange.traveler.db.tables;


import fi.istrange.traveler.db.Keys;
import fi.istrange.traveler.db.Public;
import fi.istrange.traveler.db.tables.records.UserCredentialsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserCredentials extends TableImpl<UserCredentialsRecord> {

    private static final long serialVersionUID = 1366949261;

    /**
     * The reference instance of <code>public.user_credentials</code>
     */
    public static final UserCredentials USER_CREDENTIALS = new UserCredentials();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserCredentialsRecord> getRecordType() {
        return UserCredentialsRecord.class;
    }

    /**
     * The column <code>public.user_credentials.username</code>.
     */
    public final TableField<UserCredentialsRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR.length(80), this, "");

    /**
     * The column <code>public.user_credentials.password</code>.
     */
    public final TableField<UserCredentialsRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(160), this, "");

    /**
     * The column <code>public.user_credentials.active</code>.
     */
    public final TableField<UserCredentialsRecord, Boolean> ACTIVE = createField("active", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * Create a <code>public.user_credentials</code> table reference
     */
    public UserCredentials() {
        this("user_credentials", null);
    }

    /**
     * Create an aliased <code>public.user_credentials</code> table reference
     */
    public UserCredentials(String alias) {
        this(alias, USER_CREDENTIALS);
    }

    private UserCredentials(String alias, Table<UserCredentialsRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserCredentials(String alias, Table<UserCredentialsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UserCredentialsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserCredentialsRecord, ?>>asList(Keys.USER_CREDENTIALS__USER_CREDENTIALS_USERNAME_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserCredentials as(String alias) {
        return new UserCredentials(alias, this);
    }

    /**
     * Rename this table
     */
    public UserCredentials rename(String name) {
        return new UserCredentials(name, null);
    }
}
