# DB Type Conversion

This is an example of using JPA's `@Convert` annotation to map entity attributes to non-standard column types (PostgreSQL `inet` type in this case). 

* As our converter will use PosgreSQL JDBC class `PGobject`, add the JDBC driver as a provided dependency to the `global` module in `build.gradle`:

        configure(globalModule) {
            dependencies {
                provided('org.postgresql:postgresql:9.4.1212')
            }
            //...
    
    You can also do it in Studio on the *Project properties > Advanced > Dependencies* panel.
    
    Re-create IDE project files after that (Studio does it automatically).
    
* Create a class implementing `AttributeConverter` in the `global` module and implement conversion:

        @Converter
        public class InetConverter implements AttributeConverter<String, Object> {
        
            @Override
            public Object convertToDatabaseColumn(String attribute) {
                if (attribute == null)
                    return null;
                PGobject pgobject = new PGobject();
                pgobject.setType("inet");
                try {
                    pgobject.setValue(attribute);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                return pgobject;
            }
        
            @Override
            public String convertToEntityAttribute(Object dbData) {
                return dbData == null ? null : dbData.toString();
            }
        }

* Annotate the entity attribute mapped to the column of `inet` type:
        
        @Column(name = "IP_ADDRESS")
        @Convert(converter = InetConverter.class)
        protected String ip_address;
        
* If Studio generates DDL scripts to change the column's type, click "Exclude selected" for these scripts on the *Database scripts* page.
