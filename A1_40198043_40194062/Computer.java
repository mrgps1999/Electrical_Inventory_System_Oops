// -----------------------------------------------------
// Assignment (1)
// © Pratik Gondaliya, Yash Radadiya
// Written by: (Pratik Gondaliya 40194062;
//              Yash Radadiya 40198043)
// -----------------------------------------------------


class Computer {
        String brand;
        long SN;
        String model;
        int id;
        double price = 12;
        int object_created=0;


        /**
         * This is default constructor
         */
        public Computer(){
            setBrand("");
            setModel("");
            setSN(0);
            setPrice(0);
            setId(object_created);
            object_created++;

        }
        /**
         * This is Computer which takes brand, model, SN and price in
         * orderly manner and assign value to specific object according to
         *
         * @param brand brand name (String)
         * @param model model name (String)
         * @param SN serial number (long)
         * @param price price (double)
         */
        public Computer(String brand, String model, long SN, double price) {

            setBrand(brand);
            setModel(model);
            setSN(SN);
            setPrice(price);
            setId(object_created);
            object_created++;
        }
        /**
         * This is copy constructor
         *
         * @param computer object of computer class from which you want to copy
         */
        public Computer(Computer computer){
            setBrand(computer.getBrand());
            setModel(computer.getModel());
            setSN(computer.getSN());
            setPrice(computer.getPrice());
            setId(object_created);
            object_created++;
        }
        //------------------------------------------------------
        //Here we have created getter and setter for all parameters and static value
        //------------------------------------------------------
        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public long getSN() {
            return SN;
        }

        public void setSN(long SN) {
            this.SN = SN;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
        //User of equal method
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getObject_created() {
            return object_created;
        }

        public void setObject_created(int object_created) {
            this.object_created = object_created;
        }

        /**
         * Here we have used overriding again in this first we check if object is null or from different class
         * if it's the case we are going to return false. After that we are checking by given condition that both objects are same
         * We are returning true if correct and if not we will return false
         *
         * @param obj this from object class
         * @return true or false according to brand, model and price are same or not
         */

        @Override
        public boolean equals(Object obj) {

            // checking if the two objects
            // pointing to same object
            if (this == obj)
                return true;

            // checking for two condition:
            // 1) object is pointing to null
            // 2) if the objects belong to
            // same class or not
            if (obj == null
                    || this.getClass() != obj.getClass())
                return false;

            Computer p1 = (Computer) obj; // type casting object to the
            // intended class type

            // checking if the two
            // objects share all the same values
            return this.price == p1.price
                    && this.model == p1.model
                    && this.brand.equals(p1.brand)
                    && this.SN == p1.SN;
        }

        /**
         * This concept is known as function over-riding
         * By using this we can give new definition to class function
         * here, we have override toString to print all parameters of Computer class
         *
         * @return String representation of an object
         */
        @Override
        public String toString() {
            return "Computer #" + id +
                    "\nBrand: " + brand + '\n' +
                    "Model: " + model + '\n' +
                    "SN: " + SN + '\n' +
                    "Price: $" + price + '\n';
        }
        
        //------------------------------------------------------
        //We have already static variable named as object_created and
        //it will be increased everytime new variable is going to assign
        //Thus we just have to return the value by using this function
        //------------------------------------------------------
        public int findNumberOfCreatedComputers() {
            return getObject_created();
        }
        
    }