import { nodeConfig } from './../../node.config'

const {
	db: { mysql, mongodb, mongoose, postgres },
	env: { api_prefix, port,host }
} = nodeConfig

export {
	mongodb as mongodbConfig,
	mysql as mysqlConfig,
	postgres as postgresConfig,
	port,
	api_prefix,
	mongoose as mongooseConfig,
	host
}
