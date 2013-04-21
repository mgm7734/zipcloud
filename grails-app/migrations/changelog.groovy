databaseChangeLog = {

	changeSet(author: "Mark (generated)", id: "1366502603317-1") {
		createTable(tableName: "state") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "statePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "code", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Mark (generated)", id: "1366502603317-2") {
		createTable(tableName: "zip_code_area") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "zip_code_areaPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "code", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "state_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Mark (generated)", id: "1366502603317-3") {
		addForeignKeyConstraint(baseColumnNames: "state_id", baseTableName: "zip_code_area", constraintName: "FK5A67A40187F29540", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "state", referencesUniqueColumn: "false")
	}
}
