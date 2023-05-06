.PHONY: all check-dependencies

.DEFAULT_GOAL := help


check-dependencies: ## Check dependencies
	@docker --version

help: ## Show this help
	@egrep -h '\s##\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?# "}; {printf "\033[36m%-40s\033[0m %s\n", $$1, $$2}'

docker/up: ## Run the API + database with docker compose
	@docker compose up --build -d

docker/down: ## Kill and remove API and database
	@docker compose down

docker/restart: ## Restart the app
	@docker compose down && docker compose up --build

docker/build-from-jar: ## Build jar file
	@mvn -f pom.xml clean package -Dmaven.test.skip=true
	@docker compose up --build
