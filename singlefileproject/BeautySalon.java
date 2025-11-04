import java.util.Scanner;

class Customer {
    private String name;
    private boolean isMember;
    private String membershipType;

    public void setDetails(String name, boolean isMember, String membershipType) {
        this.name = name;
        this.isMember = isMember;
        this.membershipType = membershipType;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return isMember;
    }

    public String getMembershipType() {
        if (isMember) {
            return membershipType;
        }
        return "Not a member";
    }
}

class Discount {
    public static double getServiceDiscountRate(String membershipType) {
        switch (membershipType) {
            case "Premium":
                return 0.2; // 20%
            case "Gold":
                return 0.15; // 15%
            case "Silver":
                return 0.1; // 10%
            default:
                return 0;
        }
    }

    public static double getProductDiscountRate() {
        return 0.1; // 10%
    }
}

class Visit {
    private Customer customer;
    private double serviceCost;
    private double productCost;
    private double totalDiscount;

    public void setVisitDetails(Customer customer, double serviceCost, double productCost) {
        this.customer = customer;
        this.serviceCost = serviceCost;
        this.productCost = productCost;
        this.totalDiscount = 0;

        // Apply service discount if customer is a member
        if (customer.isMember()) {
            double serviceDiscountRate = Discount.getServiceDiscountRate(customer.getMembershipType());
            this.totalDiscount += serviceCost * serviceDiscountRate;
        }

        // Apply product discount (flat 10% for all members)
        if (customer.isMember()) {
            this.totalDiscount += productCost * Discount.getProductDiscountRate();
        }
    }

    public double getTotalCost() {
        return (serviceCost + productCost) - totalDiscount;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }
}

public class BeautySalon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println("Are you a member? (yes/no)");
        String memberInput = sc.nextLine().trim().toLowerCase();
        boolean isMember = memberInput.equals("yes") || memberInput.equals("y");

        String membershipType = "None";
        if (isMember) {
            System.out.println("Select your membership type:\n1. Silver\n2. Gold\n3. Premium");
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } catch (Exception e) {
                System.out.println("Invalid input. Exiting.");
                return;
            }

            switch (choice) {
                case 1:
                    membershipType = "Silver";
                    break;
                case 2:
                    membershipType = "Gold";
                    break;
                case 3:
                    membershipType = "Premium";
                    break;
                default:
                    System.out.println("Invalid choice. Must be 1, 2, or 3.");
                    return;
            }
        }

        // Create customer
        Customer customer = new Customer();
        customer.setDetails(name, isMember, membershipType);

        // Get service cost
        System.out.println("Enter the service cost:");
        double serviceCost = sc.nextDouble();

        // Get product cost
        System.out.println("Enter the product purchase cost (0 if none):");
        double productCost = sc.nextDouble();

        // Record visit
        Visit visit = new Visit();
        visit.setVisitDetails(customer, serviceCost, productCost);

        // Output
        System.out.println("\n--- BILL SUMMARY ---");
        System.out.println("Customer: " + customer.getName());
        if (isMember) {
            System.out.println("Membership: " + membershipType);
        } else {
            System.out.println("Membership: Not a member");
        }
        System.out.println("Service Cost: " + String.format("%.2f", serviceCost));
        System.out.println("Product Cost: " + String.format("%.2f", productCost));
        System.out.println("Total Discount: " + String.format("%.2f", visit.getTotalDiscount()));
        System.out.println("Total Amount to Pay: " + String.format("%.2f", visit.getTotalCost()));

        sc.close();
    }
}
