## 🔗 **API Endpoints**

### 🔹 **Authentication**

- `POST /api/auth/register` → User registration
- `POST /api/auth/login` → Login and obtain JWT token

### 🔹 **Financial Transactions**

- `GET /api/transactions` → List all user transactions
- `POST /api/transactions` → Create a new transaction
- `PUT /api/transactions/{id}` → Edit a transaction
- `DELETE /api/transactions/{id}` → Remove a transaction

### 🔹 **Reports and Statistics**

- `GET /api/reports/monthly` → Monthly financial report
- `GET /api/reports/export/pdf` → Export report in PDF

---

## 🎯 **Main Features**

### 1️⃣ **Authentication and User Registration**

- Registration and login with **JWT (JSON Web Token)**
- Password recovery via **email**

### 2️⃣ **Transaction Management**

- Create, edit, and delete financial transactions (income and expenses)
- Categorization by type (Food, Transportation, Leisure, etc.)
- Attach receipts and invoices (image upload)

### 3️⃣ **Dashboards and Reports**

- Interactive charts (expenses by category, monthly income, balance)
- Export reports in **PDF and CSV**
- Financial goals and alerts for excessive spending

### 4️⃣ **Notifications and Alerts**

- Email notifications to remind about due bills
- Alerts for exceeding budget

---

## 🎨 **User Interface (Suggestion)**

📌 **Login Screen** → Fields for username and password, password recovery option  
📌 **Dashboard** → Overview of balance, income, and expenses for the month  
📌 **Transactions Page** → List with filters, edit and delete buttons  
📌 **Charts and Reports** → Pie and bar charts for analysis

---

## 🚀 **Differentiators and Possible Improvements**

✅ **Integration with OpenAI** to suggest smart financial strategies  
✅ **Offline Mode** with automatic synchronization when back online  
✅ **OCR for receipt scanning** and automatic entry

---

### 📆 **Next Steps**

- Create **database model** (ER diagram)
- Implement **first REST endpoints**
- Create **responsive frontend**