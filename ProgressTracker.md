📝 Wardrobe App Progress Tracker (Prefilled + Learning Notes)



1. General Info

Project Name: Wardrobe AI App

Start Date: [Add your start date]

Phase 1 — Foundation (Weeks 1–4) Week 1: Planning + Setup 🎯 Goal: Set up the project environment, design DB schema, and basic API skeleton. Install tools: IntelliJ, Postgres, Docker, Postman. Create Spring Boot project (Maven/Gradle). Setup Postgres DB + connect with Spring Data JPA. Define entities: User, Item, Outfit. Implement User Auth (Spring Security + JWT). Write API stubs: POST /auth/signup POST /auth/login GET /items Week 2: Image Upload + Storage 🎯 Goal: Allow users to upload images of clothes. Integrate AWS S3 (or local MinIO for dev). Backend API: POST /items with image upload. Save metadata in DB: name, type, image URL. Frontend (React Native/Flutter): basic upload screen. Week 3: Auto-tagging with Vision API 🎯 Goal: Extract attributes (type, color, pattern). Integrate Google Cloud Vision API (quick MVP). Write backend service: Detect item type (shirt/pants/etc). Extract dominant colors. Store extracted attributes in DB. Frontend: display tags after upload. Week 4: Manual Item Management 🎯 Goal: Let users manage their wardrobe. APIs: GET /items (list all clothes). PUT /items/{id} (edit attributes). DELETE /items/{id}. Frontend: wardrobe screen (list + filter by category). Add simple UI to edit tags if AI gets it wrong. Phase 2 — AI Outfit Engine (Weeks 5–8) Week 5: Embeddings + Similarity Search 🎯 Goal: Represent clothes in vector space for matching. Integrate CLIP embeddings (via Hugging Face / OpenAI embeddings API). Store embeddings in pgvector (Postgres extension). API: POST /items/{id}/embed → stores vector. Test similarity queries (find “closest” items). Week 6: Outfit Pairing Logic 🎯 Goal: Generate outfit suggestions. Write pairing algorithm (rule + similarity + color harmony). API: GET /outfits/suggest?occasion=party. Score outfits using: Style similarity (embedding cosine). Color harmony (LAB distance). Occasion filter (formal/casual). Return top 3–5 outfit suggestions. Week 7: Outfit Screen 🎯 Goal: Show outfits in the app. Frontend: “Suggested Outfits” screen. Display top + bottom combo with option to save. User can “like/dislike” to improve recommendations. Backend: track feedback (POST /outfits/feedback). Week 8: Learning User Preferences 🎯 Goal: Personalize outfits. Store user likes/dislikes in DB. Adjust scoring algorithm weights based on feedback. Simple ML: If user likes dark colors → increase weight for similar items. API: GET /outfits/suggest?userId=xyz (personalized). Phase 3 — Integrations & Polish (Weeks 9–12) Week 9: Import Purchases (CSV + OCR) 🎯 Goal: Fetch clothes from shopping data. Allow users to upload CSV of purchases. Parse and auto-add items. Bonus: Use Tesseract OCR for receipt images. Map brand → type + tags (basic NLP rules). Week 10: Categories & Occasions 🎯 Goal: Add more intelligence in classification. Train a small classifier (SVM/LogReg) to map clothes → occasion (party, formal, casual). Auto-tag outfits by occasion. API filter: GET /outfits/suggest?occasion=formal. Frontend: filter outfits by occasion. Week 11: UI Polish + Favorites 🎯 Goal: Make app usable & friendly. Add “Favorites” (save outfit combos). Improve wardrobe filters (by color, type, occasion). Add onboarding flow (profile setup, style preference). Add “empty state” illustrations (when no clothes exist). Week 12: Deployment + Demo 🎯 Goal: Release MVP & prepare demo. Dockerize backend. Deploy backend (AWS EC2 or GCP Cloud Run). Connect frontend to deployed API. Publish mobile app in TestFlight (iOS) or Internal Testing (Play Store). Create demo video & pitch (for portfolio/job interviews). 📌 End Result (after 12 weeks) ✅ Working MVP with: Wardrobe management (manual + auto-tagging). AI outfit suggestions (style + color + occasion). Learning from user preferences. CSV import of purchases. Deployed backend + mobile app (testable). this is the road map as a solo developer we have to go further like this learning plus developing so do u think we should add this in our daily tracker so if this chat ends i don't have to waste my time explaning like this

Current Phase: Phase 1 (Foundations)

Tech Stack: Java, Spring Boot, Postgres, React Native, Firebase/AWS S3

Learning Phase: Yes — every step will include explanations of why/how tools, libraries, and methods are used.

2. Daily / Weekly Log Table

Day / Week	Date	Learned Concepts	Implemented Features	Issues / Errors	Next Tasks	Learning Notes
1		Spring Boot basics, REST API, CRUD, Postgres setup	User signup API, DB connection	None	Test user CRUD	Learned why Spring Boot is used (rapid REST API setup), why Postgres is chosen (reliable, relational DB)
2		Controller, Service, Repository layers	Update user API	Null pointer in update	Add delete user API	Learned separation of concerns: Controller handles HTTP, Service handles business logic, Repository talks to DB
3		Delete API, Postman testing	Delete user API	None	Add validations for user fields	Learned why testing with Postman helps verify APIs before frontend integration
4		Spring Boot layers review, business logic separation	User CRUD complete (create, read, update, delete)	None	Move to Item CRUD (upload clothes)	Reinforced layer responsibilities; ready to extend for Items table
5		Bean validations (@Valid, @NotBlank, @Email, @Size)	Start adding validation in user API	Test with Postman	Complete validations and test all CRUD	Learned why validations are needed (data integrity, user feedback, avoiding bad DB entries)
6		—	—	—	Start implementing Item (Clothes) CRUD and image upload	Will explain why we use MultipartFile for image uploads, why cloud storage like Firebase/S3 is recommended

3. Phase Overview

Phase	Duration	Goal	Status	Notes
Phase 1	Week 1–2	Basic CRUD + login + wardrobe grid	In Progress	Completed user CRUD, testing with Postman; learning phase with explanations
Phase 2	Week 3–5	Auto-tag clothes, filters	Pending	Will explain Vision API, color/type extraction, rule engine
Phase 3	Week 6–8	Outfit suggestions	Pending	Will explain embeddings, recommendation scoring, color harmony
Phase 4	Week 9–10	Smart imports, OCR	Pending	Will explain Tesseract / Google Vision OCR and parsing logic
Phase 5	Week 11–12	Polish & deployment	Pending	Will explain deployment steps (Heroku/AWS) and frontend integration

4. Feature Checklist

User Auth (signup/login)

User CRUD (create, read, update, delete)

Item CRUD (upload, list, edit, delete)

Image storage (Firebase / S3)

Auto-tagging with Vision API

Outfit suggestion engine

Outfit saving & favorites

CSV/Receipt import + OCR

Frontend screens (React Native)

Deployment (Heroku / AWS)

Analytics & Admin dashboard

5. Notes / References

Postman test endpoints: /users CRUD

Validations to add: @NotBlank, @Email, @Size, optional unique email constraint

Spring Boot layers: Controller → Service → Repository → DB

Learning Phase Notes:

Every step includes why we use each tool or annotation.

Example: @RestController = handles HTTP responses in JSON.

Example: Postgres = stores relational data, supports indexing, queries, and can scale.

Example: @Valid = ensures only correct data is saved; prevents backend errors.

Day 5 — Update API with Validations

Date: (add today’s date)

Goal:

Implement updateUser API with proper input validation.

Understand Controller → Service → Repository flow.

What We Are Using:

Spring Boot (@RestController, @Autowired)

Spring Data JPA (UserRepository)

Bean Validation (@NotBlank, @Email, @Size)

@Valid in Controller

@PathVariable to get id from URL

Logic / Flow:

Controller receives PUT request /user/update/{id}

Input fields validated automatically via @Valid and annotations

Service layer checks if user exists in DB:

If not → return "User not found"

If exists:

Update email and password

Optional: check for duplicate email

Save updated user in DB

Return success message → "User updated successfully"

Extra Challenge:

Prevent duplicate email updates by checking DB

Understand why we use @PathVariable

Next Steps:

Implement the validations in User.java

Test API using Postman with valid and invalid inputs

Observe automatic error messages for invalid inputs