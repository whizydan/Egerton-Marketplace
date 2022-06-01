import expressLoader from './../expressLoader'
import express from 'express'

const app = express()
expressLoader({ app })

export default app
