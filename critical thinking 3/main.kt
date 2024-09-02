import java.util.Scanner

fun main() {
    val contacts = mutableMapOf<String, String>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\nContact Book Application")
        println("1. Add Contact")
        println("2. Edit Contact")
        println("3. Delete Contact")
		println("4. View Contacts")
        println("5. Exit")
        print("Choose an option: ")

        when (scanner.nextInt()) {
            1 -> addContact(scanner, contacts)
            2 -> editContact(scanner, contacts)
            3 -> deleteContact(scanner, contacts)
			4 -> viewContacts(contacts)
            5 -> {
                println("Exiting...")
                break
            }
            else -> println("Invalid option, please try again.")
        }
    }
}

fun addContact(scanner: Scanner, contacts: MutableMap<String, String>) {
    print("Enter Name: ")
    val name = scanner.next()
    print("Enter Phone Number: ")
    val phone = scanner.next()

    if (contacts.containsKey(name)) {
        println("Contact already exists. Use edit option to update the contact.")
    } else {
        contacts[name] = phone
        println("Contact added successfully.")
    }
}

fun editContact(scanner: Scanner, contacts: MutableMap<String, String>) {
    print("Enter Name of the Contact to Edit: ")
    val name = scanner.next()

    if (contacts.containsKey(name)) {
        print("Enter New Phone Number: ")
        val phone = scanner.next()
        contacts[name] = phone
        println("Contact updated successfully.")
    } else {
        println("Contact not found.")
    }
}

fun deleteContact(scanner: Scanner, contacts: MutableMap<String, String>) {
    print("Enter Name of the Contact to Delete: ")
    val name = scanner.next()

    if (contacts.containsKey(name)) {
        contacts.remove(name)
        println("Contact deleted successfully.")
    } else {
        println("Contact not found.")
    }
}

fun viewContacts(contacts: Map<String, String>) {
    if (contacts.isEmpty()) {
        println("No contacts available.")
    } else {
        println("\nAll Contacts:")
        for ((name, phone) in contacts) {
            println("Name: $name, Phone: $phone")
        }
    }
}