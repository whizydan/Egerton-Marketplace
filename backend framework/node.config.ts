import dotenv from 'dotenv'

dotenv.config()

export const nodeConfig = {
	env: {
		port: process.env.PORT || 5000,
		api_prefix: '/api/v1',
		host: process.env.HOST || 'localhost'
	},
	db: {
		mysql: {
			port: process.env.MYSQL_PORT || 3306,
			host: process.env.MYSQL_HOST || '127.0.0.1',
			user: process.env.MYSQL_USERNAME || 'root',
			pass: process.env.MYSQL_PASSWORD || ''
		},
		postgres: {
			port: process.env.POSTGRES_PORT || 5017,
			host: process.env.POSTGRES_HOST || '127.0.0.1',
			user: process.env.POSTGRES_USERNAME || 'postgres',
			pass: process.env.POSTGRES_PASSWORD || ''
		},
		mongoose: {
			url: process.env.MONGO_URL || 'mongodb://127.0.1:27017/test-db'
		},
		mongodb: {
			port: process.env.MONGO_DB_PORT || 27017,
			host: process.env.MONGO_DB_HOST || '127.0.0.1',
			user: process.env.MONGO_DB_USERNAME || '',
			pass: process.env.MONGO_DB_PASSWORD || ''
		}
	}
}
