package sql;

public class CombineTwoTables {

    /**
     *
     *
     * Table: Person
     *
     * +-------------+---------+
     * | Column Name | Type    |
     * +-------------+---------+
     * | PersonId    | int     |
     * | FirstName   | varchar |
     * | LastName    | varchar |
     * +-------------+---------+
     * PersonId is the primary key column for this table.
     * Table: Address
     *
     * +-------------+---------+
     * | Column Name | Type    |
     * +-------------+---------+
     * | AddressId   | int     |
     * | PersonId    | int     |
     * | City        | varchar |
     * | State       | varchar |
     * +-------------+---------+
     * AddressId is the primary key column for this table.
     *
     *
     *
     * select FirstName, LastName, City, State
     * from Person left join Address
     * on Person.PersonId = Address.PersonId;
     */
}
